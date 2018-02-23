package org.ywj.opentcc.core.model;

import java.io.Serializable;

/**
 * 文件描述:事务方法上下文(记录confirm与cancel)
 * 作者: yinwenjie
 * 日期: 2018-02-08
 */
public class TccMethodContext implements Serializable {

    private static final long serialVersionUID = -992060666835778475L;

    private Class targetClass;

    private String methodName;

    private Class[] parameterTypes;

    private Object[] args;


    public TccMethodContext(Class targetClass, String methodName, Class[] parameterTypes, Object[] args) {
        this.targetClass = targetClass;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.args = args;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public Object[] getArgs() {
        return args;
    }
}
