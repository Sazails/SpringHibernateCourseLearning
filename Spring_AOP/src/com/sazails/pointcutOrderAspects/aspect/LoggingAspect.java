package com.sazails.pointcutOrderAspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    @Before("AopExpressions.daoPackageNoGetterSetter()")
    public void beforeAddAccountAspect() {
        System.out.println(getClass() + " Executing @Before advice on addAccount()");
    }
}

