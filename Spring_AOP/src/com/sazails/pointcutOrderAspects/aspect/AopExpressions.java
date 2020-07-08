package com.sazails.pointcutOrderAspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // Pointcut for getter and setter methods
    @Pointcut("execution(* com.sazails.pointcutOrderAspects.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.sazails.pointcutOrderAspects.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("daoPackage() && !(getter() || setter())") // dont include getter and setter methods
    public void daoPackageNoGetterSetter() {}

    @Pointcut("execution(* com.sazails.pointcutOrderAspects.dao.*.*(..))")
    public void daoPackage() {}
}
