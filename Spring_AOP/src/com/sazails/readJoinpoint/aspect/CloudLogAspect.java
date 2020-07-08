package com.sazails.readJoinpoint.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class CloudLogAspect {

    @Before("AopExpressions.daoPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println(getClass() + " Executing @Before advice on logToCloud()");
    }
}
