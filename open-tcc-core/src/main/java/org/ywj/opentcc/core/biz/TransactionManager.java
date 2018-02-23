package org.ywj.opentcc.core.biz;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ywj.opentcc.api.TransactionContext;
import org.ywj.opentcc.api.TransactionStatus;
import org.ywj.opentcc.common.exception.NoTrxFoundException;
import org.ywj.opentcc.common.exception.TccCancelException;
import org.ywj.opentcc.common.exception.TccCommonException;
import org.ywj.opentcc.common.exception.TccConfirmException;
import org.ywj.opentcc.common.serialize.ObjectSerializer;
import org.ywj.opentcc.core.enums.TrxType;
import org.ywj.opentcc.core.model.Performer;
import org.ywj.opentcc.core.model.Transaction;
import org.ywj.opentcc.dal.dao.TransactionDAO;
import org.ywj.opentcc.dal.entity.TccTrxDo;

import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
@Service
public class TransactionManager {

    @Autowired
    private TransactionDAO transactionDAO;

    private ObjectSerializer<Transaction> serializer = new ObjectSerializer<Transaction>();

    private static final ThreadLocal<Deque<Transaction>> CURRENT = new ThreadLocal<Deque<Transaction>>();

    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    public Transaction begin() {
        Transaction transaction = new Transaction(TrxType.ROOT);
        TccTrxDo tccTrxDo = new TccTrxDo();
        transactionConvert(transaction, tccTrxDo);
        transactionDAO.insert(tccTrxDo);
        registerTransaction(transaction);
        return transaction;
    }


    public Transaction branchBegin(TransactionContext transactionContext) {
        Transaction transaction = new Transaction(transactionContext);
        TccTrxDo tccTrxDo = new TccTrxDo();
        transactionConvert(transaction, tccTrxDo);
        transactionDAO.insert(tccTrxDo);
        registerTransaction(transaction);
        return transaction;
    }

    public Transaction branchExistBegin(TransactionContext transactionContext) throws Exception {
        TccTrxDo tccTrxDo = transactionDAO.findByTrxId(transactionContext.getGroupTrxId(), transactionContext.getBranchTrxId());
        if (tccTrxDo != null) {
            Transaction transaction = transactionConvert(tccTrxDo);
            transaction.setStatus(transactionContext.getStatus());
            // 注册transaction
            registerTransaction(transaction);
            return transaction;
        } else {
            throw new NoTrxFoundException();
        }
    }

    public void syncTransaction() {

        Transaction transaction = getCurrentTransaction();
        transaction.setGmtModified(new Date());
        TccTrxDo tccTrxDo = new TccTrxDo();
        transactionConvertWithVersionAdd(transaction, tccTrxDo);
        transactionDAO.OpstimisticLockUpdate(tccTrxDo);
    }

    public void rollback(boolean isAsyncCancel) {
        final Transaction transaction = getCurrentTransaction();
        transaction.setStatus(TransactionStatus.CANCELLING.getStatus());
        transaction.setGmtModified(new Date());
        // 更新tcc中的状态
        TccTrxDo tccTrxDo = new TccTrxDo();
        transactionConvertWithVersionAdd(transaction, tccTrxDo);
        transactionDAO.OpstimisticLockUpdate(tccTrxDo);
        // 执行performer的cancel操作
        if (isAsyncCancel) {
            try {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        trxRollback(transaction);
                    }
                });
            } catch (Throwable throwable) {
                System.out.println("open-tcc async rollback has exception" + throwable);
                throw new TccCancelException(throwable);
            }
        } else {
            trxRollback(transaction);
        }

    }

    public void commit(boolean isAsyncConfirm) {
        final Transaction transaction = getCurrentTransaction();
        transaction.setStatus(TransactionStatus.CONFIRMING.getStatus());
        transaction.setGmtModified(new Date());
        // 更新tcc中的状态
        TccTrxDo tccTrxDo = new TccTrxDo();
        transactionConvertWithVersionAdd(transaction, tccTrxDo);
        transactionDAO.OpstimisticLockUpdate(tccTrxDo);
        if (isAsyncConfirm) {
            try {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        trxCommit(transaction);
                    }
                });
            } catch (Throwable throwable) {
                System.out.println("open-tcc async commit has exception" + throwable);
                throw new TccConfirmException(throwable);
            }
        } else {
            trxCommit(transaction);
        }

    }

    public void cleanCurrentTransaction(Transaction transaction) {
        if (transactionRunning() && transaction != null) {
            if (transaction == getCurrentTransaction()) {
                CURRENT.get().pop();
            } else {
                throw new TccCommonException("transaction not equal when trx end");
            }
        }
    }

    public void addPerformer(Performer performer) {

        Transaction transaction = this.getCurrentTransaction();
        transaction.addPerformers(performer);
        transaction.setGmtModified(new Date());
        TccTrxDo tccTrxDo = new TccTrxDo();
        transactionConvertWithVersionAdd(transaction, tccTrxDo);
        transactionDAO.update(tccTrxDo);
//        transaction.versionAdd();
    }

    public Transaction getCurrentTransaction() {
        if (transactionRunning()) {
            return CURRENT.get().peek();    //头部元素 只是取出不删除
        }
        return null;
    }

    public boolean transactionRunning() {
        return CURRENT.get() != null && (!CURRENT.get().isEmpty());
    }

    private void registerTransaction(Transaction transaction) {

        if (CURRENT.get() == null) {
            CURRENT.set(new LinkedList<Transaction>());
        }

        CURRENT.get().push(transaction);
    }

    //update相关操作时使用
    private void transactionConvertWithVersionAdd(Transaction transaction, TccTrxDo tccTrxDo) {
        int version = transaction.getVersion() + 1;
        transactionConvert(transaction, tccTrxDo, version);
    }

    private void transactionConvert(Transaction transaction, TccTrxDo tccTrxDo) {
        int version = transaction.getVersion();
        transactionConvert(transaction, tccTrxDo, version);
    }

    /**
     * 将 Transaction 转换为 TccTrxDo
     * @param transaction
     * @param tccTrxDo
     * @param version
     */
    private void transactionConvert(Transaction transaction, TccTrxDo tccTrxDo, int version) {
        BeanUtils.copyProperties(transaction, tccTrxDo);
        transaction.setVersion(version);
        tccTrxDo.setContent(serializer.serialize(transaction));
    }

    /**
     * 将 TccTrxDo 准换为 Transaction
     * @param tccTrxDo
     * @return Transaction
     */
    private Transaction transactionConvert(TccTrxDo tccTrxDo) {
        byte[] content = tccTrxDo.getContent();
        Transaction transaction = serializer.deserialize(content);
        //设置相关属性
        transaction.setStatus(tccTrxDo.getStatus());
        transaction.setGmtModified(tccTrxDo.getGmtModified());
        transaction.setVersion(tccTrxDo.getVersion());
        transaction.setRetryTimes(tccTrxDo.getRetryTimes());
        return transaction;
    }

    private void trxRollback(Transaction transaction) {
        try {
            transaction.rollback();
        } catch (Throwable throwable) {
            //logger
            throw new TccCancelException(throwable);
        }
    }

    private void trxCommit(Transaction transaction) {
        try {
            transaction.commit();
        } catch (Throwable throwable) {
            //logger
            throw new TccConfirmException(throwable);
        }
    }
}
