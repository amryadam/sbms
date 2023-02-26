package com.amryadam.sbms.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1) // order in which aspect is run
@Component
public class ApiAspect {

    @Pointcut("execution(* com.amryadam.sbms.controller.*.*(..))")
    private void forApi(){}

    @Pointcut("execution(* com.amryadam.sbms.controller.*.get*(..))")
    private void getter(){}
    @Pointcut("execution(* com.amryadam.sbms.controller.*.setter*(..))")

    private void setter(){}

    // combine pointcut: include package ... exclude getter / setter
    @Pointcut("forApi() && !(getter()|| setter())")
    private void forApiNotGetterSetter(){}
}
