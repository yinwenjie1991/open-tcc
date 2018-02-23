package org.ywj.opentcc.core.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.ywj.opentcc.api.TransactionContext;

import java.lang.reflect.Method;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
public class ReflectionUtil {

    public static Method getPointMethod(ProceedingJoinPoint point) {
        Method method = ((MethodSignature)point.getSignature()).getMethod();

        return method;
    }

    public static TransactionContext getPointTransactionContext(Method method, Object[] args) {
        int position = getTransactionContextPosition(method.getParameterTypes());
        if (position >= 0 ) {
            return (TransactionContext) args[position];
        }
        return null;
    }

    public static void setPointTransactionContext(TransactionContext transactionContext
            , Method method, Object[] args) {
        int position = getTransactionContextPosition(method.getParameterTypes());
        if (position >= 0) {
            args[position] = transactionContext;
        }
    }

    public static int getTransactionContextPosition(Class<?>[] parameterTypes) {

        int position = -1;

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].equals(TransactionContext.class)) {
                position = i;
                break;
            }
        }
        return position;
    }

    public static Object getNullValue(Class type) {

        if (boolean.class.equals(type)) {
            return false;
        } else if (byte.class.equals(type)) {
            return 0;
        } else if (short.class.equals(type)) {
            return 0;
        } else if (int.class.equals(type)) {
            return 0;
        } else if (long.class.equals(type)) {
            return 0;
        } else if (float.class.equals(type)) {
            return 0;
        } else if (double.class.equals(type)) {
            return 0;
        }

        return null;
    }
}
