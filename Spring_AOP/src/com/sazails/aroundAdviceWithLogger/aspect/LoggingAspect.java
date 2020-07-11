package com.sazails.aroundAdviceWithLogger.aspect;

import com.sazails.aroundAdviceWithLogger.Main;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    @Around("execution(* com.sazails.aroundAdviceWithLogger.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // Print the advised method
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info(" Executing @Around on method: " + method);

        long timeStart = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - timeStart;

        logger.info("Execution took: " + timeTaken + " milliseconds.");
        return result;
    }
}

