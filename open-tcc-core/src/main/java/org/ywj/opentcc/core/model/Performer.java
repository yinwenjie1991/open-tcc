package org.ywj.opentcc.core.model;

import org.omg.CORBA.SystemException;
import org.ywj.opentcc.api.TransactionContext;
import org.ywj.opentcc.api.TransactionStatus;
import org.ywj.opentcc.common.util.StringUtil;
import org.ywj.opentcc.core.enums.TrxType;
import org.ywj.opentcc.core.util.ReflectionUtil;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public class Performer implements Serializable {

    private static final long serialVersionUID = -6783442269012457042L;

    private String groupTrxId;

    private String branchTrxId;

    private TccMethodContext confirmContext;

    private TccMethodContext cancelContext;

    public Performer(String groupTrxId, String branchTrxId, TccMethodContext confirmContext, TccMethodContext cancelContext) {
        this.groupTrxId = groupTrxId;
        this.branchTrxId = branchTrxId;
        this.confirmContext = confirmContext;
        this.cancelContext = cancelContext;
    }


    private Object methodInvoke(TransactionContext transactionContext, TccMethodContext tccMethodContext) {
        if (!StringUtil.isEmpty(tccMethodContext.getMethodName())) {
            try {
                Method method = tccMethodContext.getTargetClass().getMethod(tccMethodContext.getMethodName(), tccMethodContext.getParameterTypes());
                ReflectionUtil.setPointTransactionContext(transactionContext, method, tccMethodContext.getArgs());
                return method.invoke(tccMethodContext.getTargetClass(), tccMethodContext.getArgs());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void rollback() {
        methodInvoke(
                new TransactionContext(this.groupTrxId, this.branchTrxId, TransactionStatus.CANCELLING.getStatus())
                , cancelContext);
    }

    public void commit() {
        methodInvoke(new TransactionContext(this.groupTrxId, this.branchTrxId, TransactionStatus.CONFIRMING.getStatus())
                , confirmContext);
    }
}
