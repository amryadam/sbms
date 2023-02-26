package com.amryadam.sbms.aop;


import com.amryadam.sbms.model.customers.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class LoggingAspect {

    // Custom point cut declaration
    @Pointcut("execution(public * add(..))")
    private void forAdd(){};

    @AfterReturning(pointcut = "forAdd()",returning = "returnedVariable")
    public void WriteToConsole(JoinPoint joinPoint,Object returnedVariable){}

    @AfterThrowing(pointcut = "forAdd()",throwing = "theExc")
    public void AfterThrowingAdvice(JoinPoint joinPoint,Throwable theExc){}


    //TODO note working
    @AfterReturning(pointcut = "execution(* CreateCustomer(..))",returning = "result")
    public void AfterReturningAdvice(JoinPoint joinPoint,Customer result){

        result.setCode("123456");
        System.out.println("call from Advice " + result);

    }


}
