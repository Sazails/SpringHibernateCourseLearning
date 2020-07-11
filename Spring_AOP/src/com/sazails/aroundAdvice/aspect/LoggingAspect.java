package com.sazails.aroundAdvice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.sazails.aroundAdvice.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // Print the advised method
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println(" Executing @Around on method: " + method);

        long timeStart = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - timeStart;

        System.out.println("Execution took: " + timeTaken + " milliseconds.");
        return result;
    }
}

