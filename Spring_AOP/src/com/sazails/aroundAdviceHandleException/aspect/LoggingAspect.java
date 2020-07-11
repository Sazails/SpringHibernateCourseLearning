package com.sazails.aroundAdviceHandleException.aspect;

import com.sazails.aroundAdviceHandleException.Main;
import com.sazails.aroundAdviceHandleException.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(0)
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

    @After("execution(* com.sazails.aroundAdviceHandleException.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint){
        // Print the advised method
        String method = joinPoint.getSignature().toShortString();
        logger.info(" Executing @After on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.sazails.aroundAdviceHandleException.dao.AccountDAO.findAccounts(..))", throwing = "ex")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex){
        // Print the advised method
        String method = joinPoint.getSignature().toShortString();
        logger.info(" Executing @AfterThrowing on method: " + method);

        // Print method call results
        logger.info(" Exception: " + ex);
    }

    @AfterReturning(pointcut = "execution(* com.sazails.aroundAdviceHandleException.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        // Print the advised method
        String method = joinPoint.getSignature().toShortString();
        logger.info(" Executing @AfterReturning on method: " + method);

        // Print method call results
        logger.info(" Result: " + result);

        convertAccountNamesToLowerCase(result);

        // Print modified results
        logger.info(" Result: " + result);
    }

    private void convertAccountNamesToLowerCase(List<Account> result){
        for(Account account : result){
            account.setUsername(account.getUsername().toLowerCase());
        }
    }
}

