package org.ywj.opentcc.core.util;

import org.ywj.opentcc.api.Propagation;
import org.ywj.opentcc.api.TransactionContext;
import org.ywj.opentcc.core.enums.TransactionType;
import org.ywj.opentcc.core.model.Transaction;

import java.lang.reflect.Method;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public class TransactionUtil {

    public static boolean isLegalTransactionContext(boolean transactionRunning
            , Propagation propagation, TransactionContext transactionContext) {
        if (propagation == Propagation.MANDATORY && !transactionRunning && transactionContext == null) {
            return false;
        }
        return true;
    }

    public static TransactionType calTransactionType(Propagation propagation
            , boolean transactionRunning, TransactionContext transactionContext) {
        if ( propagation == Propagation.REQUIRED && !transactionRunning && transactionContext == null ||
                propagation == Propagation.REQUIRES_NEW) {
            return TransactionType.ROOT;
        } else if ((propagation == Propagation.REQUIRED) ||
                propagation == Propagation.MANDATORY && !transactionRunning && transactionContext!= null) {
            return TransactionType.BRANCH;
        } else {
            return TransactionType.REMOTE;
        }
    }

//    public static TransactionContext getTransactionContextParam(Method method, Object[] args) {
//
//        Class<?>[] parameterTypes = method.getParameterTypes();
//        for (int i = 0; i < parameterTypes.length; i++) {
//            if (parameterTypes[i].equals(TransactionContext.class)) {
//                return (TransactionContext) args [i];
//            }
//        }
//
//        return null;
//
//    }
//
//    public static void setTransactionContextParam(TransactionContext transactionContext
//            , Method method, Object[] args) {
//
//        Class<?>[] parameterTypes = method.getParameterTypes();
//        for (int i = 0; i < parameterTypes.length; i++) {
//            if (parameterTypes[i].equals(TransactionContext.class)) {
//                args[i] = transactionContext;
//            }
//        }
//
//    }
}
