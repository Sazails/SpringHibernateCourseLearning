package com.sazails.pointcutDeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.sazails.pointcutDeclaration.dao.*.*(..))")
    private void daoPackage() {}

    @Before("daoPackage()")
    public void beforeAddAccountAspect(){
        System.out.println(getClass() + " Executing @Before advice on addAccount()");
    }

    @Before("daoPackage()")
    public void performApiAnalytics(){
        System.out.println(getClass() + " Executing @Before advice on performApiAnalytics()");
    }
}
