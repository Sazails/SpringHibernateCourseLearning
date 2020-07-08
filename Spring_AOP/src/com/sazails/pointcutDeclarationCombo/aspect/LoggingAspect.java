package com.sazails.pointcutDeclarationCombo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut for getter and setter methods
    @Pointcut("execution(* com.sazails.pointcutDeclarationCombo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.sazails.pointcutDeclarationCombo.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("daoPackage() && !(getter() || setter())") // dont include getter and setter methods
    private void daoPackageNoGetterSetter() {}

    @Pointcut("execution(* com.sazails.pointcutDeclarationCombo.dao.*.*(..))")
    private void daoPackage() {}

    @Before("daoPackageNoGetterSetter()")
    public void beforeAddAccountAspect() {
        System.out.println(getClass() + " Executing @Before advice on addAccount()");
    }

    @Before("daoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println(getClass() + " Executing @Before advice on performApiAnalytics()");
    }
}
