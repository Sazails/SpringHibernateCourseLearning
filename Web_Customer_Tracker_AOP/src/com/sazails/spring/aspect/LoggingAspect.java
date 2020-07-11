package com.sazails.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.sazails.spring.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.sazails.spring.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.sazails.spring.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        logger.info("@Before from method: " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            logger.info("Argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        logger.info("@AfterReturning from method: " + joinPoint.getSignature().toShortString());
        logger.info("Result: " + result);
    }
}
