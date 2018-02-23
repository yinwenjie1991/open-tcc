package org.ywj.opentcc.dal.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-02
 */
@Aspect
@Component
public class MyAspect implements Ordered{

    @Pointcut("@annotation(org.ywj.opentcc.dal.aop.Action)")
    public void log() {

    }

//    @Before("log()")
//    public void aroundM(JoinPoint joinPoint) {
//        System.out.println(" -------- before aspectj --------");
//    }

    @Around("log()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.getSignature().getName());
//        pjp.proceed();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
