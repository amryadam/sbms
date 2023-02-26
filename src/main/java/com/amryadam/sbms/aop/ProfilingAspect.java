package com.amryadam.sbms.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilingAspect {

    //@Around("execution(* com.amryadam.sbms.controller.*.add(..))")
    public Object CalcTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end  = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println(duration);

        return result;

    }
}
