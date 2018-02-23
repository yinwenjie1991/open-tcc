package org.ywj.opentcc.core.aop.interceptor;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ywj.opentcc.api.Propagation;
import org.ywj.opentcc.api.TCC;
import org.ywj.opentcc.api.TransactionContext;
import org.ywj.opentcc.api.TransactionStatus;
import org.ywj.opentcc.common.exception.NoTrxFoundException;
import org.ywj.opentcc.common.exception.OptimitsticLockException;
import org.ywj.opentcc.common.util.UUIDUtils;
import org.ywj.opentcc.core.biz.TransactionManager;
import org.ywj.opentcc.core.enums.TransactionType;
import org.ywj.opentcc.core.model.Performer;
import org.ywj.opentcc.core.model.TccMethodContext;
import org.ywj.opentcc.core.model.Transaction;
import org.ywj.opentcc.core.util.ReflectionUtil;
import org.ywj.opentcc.core.util.TransactionUtil;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
@Component
public class TccTransactionInterceptor {

    @Autowired
    private TransactionManager transactionManager;

    private Set<Class<? extends Exception>> unknownExceptions = new HashSet<Class<? extends Exception>>();

    @PostConstruct
    public void init() {
        this.unknownExceptions.add(SocketTimeoutException.class);
        this.unknownExceptions.add(OptimitsticLockException.class);
    }

    public Object intercept(ProceedingJoinPoint point) throws Throwable{
        Method method = ReflectionUtil.getPointMethod(point);

        //获取tcc注解的相关参数
        TCC tcc = method.getAnnotation(TCC.class);
        Propagation propagation = tcc.propagation();
        String confirmMethodName = tcc.confirm();
        String cancelMethodName = tcc.cancle();
        boolean isAsyncConfirm = tcc.asyncConfirm();
        boolean isAsyncCancel = tcc.asyncCancel();

        TransactionContext transactionContext = ReflectionUtil.getPointTransactionContext(
                method, point.getArgs()
        );

        boolean transactionRunning = transactionManager.transactionRunning();
        if (TransactionUtil.isLegalTransactionContext( transactionRunning, propagation, transactionContext)) {
            throw new RuntimeException("no transactions where propagation is MANDATORY, the method is : "
                    + method.getName());
        }

        TransactionType transactionType = TransactionUtil.calTransactionType(propagation
                , transactionRunning, transactionContext);

        switch (transactionType) {
            case ROOT:
                return rootTransactionExec(point, confirmMethodName, cancelMethodName
                        , isAsyncConfirm, isAsyncCancel, method);
            case BRANCH:
                return branchTransactionExec(point, transactionContext, confirmMethodName
                        , cancelMethodName, isAsyncConfirm, isAsyncCancel, method);
            case REMOTE:
                return remoteTransactionExec(point, confirmMethodName, cancelMethodName
                        , isAsyncConfirm, isAsyncCancel, method);

        }
        return null;
    }

    private Object rootTransactionExec(ProceedingJoinPoint point, String confirmMethodName
            , String cancelMethodName, boolean isAsyncConfirm
            , boolean isAsyncCancel, Method method) throws Throwable{
        Object result = null;
        Transaction transaction = null;
        try {
            transaction = transactionManager.begin();
            performerRegister(point, confirmMethodName, cancelMethodName
                    , isAsyncConfirm, isAsyncCancel, method);

            try {
                result = point.proceed();
            } catch (Throwable throwable) {
                if (isUnknwonStatusException(throwable)) {
                    //tcc事务保存
                    transactionManager.syncTransaction();
                } else {
                    //tcc事务回滚
                    transactionManager.rollback(isAsyncCancel);
                }
                throw throwable;
            }
            transactionManager.commit(isAsyncConfirm);
        }finally {
            //事务完成，清空事务
            transactionManager.cleanCurrentTransaction(transaction);
        }
        return result;
    }

    private Object branchTransactionExec(ProceedingJoinPoint point, TransactionContext transactionContext
            , String confirmMethodName, String cancelMethodName
            , boolean isAsyncConfirm, boolean isAsyncCancel
            , Method method) throws Throwable{
        Transaction transaction = null;
        try {
            switch (TransactionStatus.valueOf(transactionContext.getStatus())) {
                case TRYING:
                    //在表中创建分支事务
                    transaction = transactionManager.branchBegin(transactionContext);
                    performerRegister(point, confirmMethodName, cancelMethodName
                            , isAsyncConfirm, isAsyncCancel, method);
                    return point.proceed();
                case CONFIRMING:
                    try {
                        transaction = transactionManager.branchExistBegin(transactionContext);
                        transactionManager.commit(isAsyncConfirm);
                    } catch (NoTrxFoundException e) {

                    }
                    break;
                case CANCELLING:
                    try {
                        transaction = transactionManager.branchExistBegin(transactionContext);
                        transactionManager.rollback(isAsyncCancel);
                    } catch (NoTrxFoundException e) {

                    }
                    break;
            }

        } finally {
            transactionManager.cleanCurrentTransaction(transaction);
        }
        return ReflectionUtil.getNullValue(method.getReturnType());

    }

    private Object remoteTransactionExec(ProceedingJoinPoint point, String confirmMethodName
            , String cancelMethodName, boolean isAsyncConfirm
            , boolean isAsyncCancel, Method method) throws Throwable {
        //注册performer
        performerRegister(point, confirmMethodName, cancelMethodName, isAsyncConfirm
                , isAsyncCancel, method);
        return point.proceed();
    }

    private void performerRegister(ProceedingJoinPoint point, String confirmMethodName
            , String cancelMethodName, boolean isAsyncConfirm
            , boolean isAsyncCancel, Method method) throws Throwable {

        Transaction transaction = transactionManager.getCurrentTransaction();

        if ( transaction != null) {
            switch (TransactionStatus.valueOf(transaction.getStatus())) {
                case TRYING:
                    //构造新的事务上下文
                    if (ReflectionUtil.getPointTransactionContext(method, point.getArgs()) == null) {
                        ReflectionUtil.setPointTransactionContext(
                                new TransactionContext(transaction.getGroupTrxId(), UUIDUtils.uuid(), TransactionStatus.TRYING.getStatus())
                                , method, point.getArgs()
                        );
                    }

                    Class targetClass = point.getTarget().getClass();
                    TccMethodContext confirmContext = new TccMethodContext(targetClass
                            , confirmMethodName, method.getParameterTypes()
                            , point.getArgs());
                    TccMethodContext cancelContext = new TccMethodContext(targetClass
                            , cancelMethodName, method.getParameterTypes()
                            , point.getArgs());

                    Performer performer = new Performer(transaction.getGroupTrxId()
                            , UUIDUtils.uuid(), confirmContext, cancelContext);
                    transactionManager.addPerformer(performer);
                    break;
                case CONFIRMING:
                    break;
                case CANCELLING:
                    break;
            }
        }
    }

    private boolean isUnknwonStatusException(Throwable throwable) {

        for (Class exceptionClass : unknownExceptions) {
            Throwable rootCause = ExceptionUtils.getRootCause(throwable);
            if (exceptionClass.isAssignableFrom(throwable.getClass())
                    || (rootCause != null && exceptionClass.isAssignableFrom(rootCause.getClass()))) {
                return true;
            }
        }
        return false;
    }
}
