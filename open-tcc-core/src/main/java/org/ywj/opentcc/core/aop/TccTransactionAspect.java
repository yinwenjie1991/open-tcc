package org.ywj.opentcc.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ywj.opentcc.core.aop.interceptor.TccTransactionInterceptor;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-05
 */
@Component
@Aspect
public class TccTransactionAspect {

    @Autowired
    private TccTransactionInterceptor tccTransactionInterceptor;

    @Pointcut("@annotation(org.ywj.opentcc.api.TCC)")
    public void tcc() {

    }

    @Around("tcc()")
    public Object transactionIntercepter(ProceedingJoinPoint point) throws Throwable {
        return tccTransactionInterceptor.intercept(point);
    }
}
