package com.sazails.pointcutOrderAspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAnalyticsAspect {

    @Before("AopExpressions.daoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println(getClass() + " Executing @Before advice on performApiAnalytics()");
    }
}
