package com.sazails.aroundAdviceHandleException.aspect;

import com.sazails.aroundAdviceHandleException.Main;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    @Around("execution(* com.sazails.aroundAdviceHandleException.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // Print the advised method
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info(" Executing @Around on method: " + method);

        long timeStart = System.currentTimeMillis();

        Object result = null;

        try{
            result = proceedingJoinPoint.proceed();
        }catch (Exception ex){
            logger.warning(ex.getMessage());

            // Handle exception
            result = "This is the handled fortune exception.";

            // Rethrow exception
            return ex;
        }

        long timeTaken = System.currentTimeMillis() - timeStart;

        logger.info("Execution took: " + timeTaken + " milliseconds.");
        return result;
    }
}

