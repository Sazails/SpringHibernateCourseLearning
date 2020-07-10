package com.sazails.afterAdvice.aspect;

import com.sazails.afterAdvice.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    @After("execution(* com.sazails.afterAdvice.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint){
        // Print the advised method
        String method = joinPoint.getSignature().toShortString();
        System.out.println(" Executing @After on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.sazails.afterAdvice.dao.AccountDAO.findAccounts(..))", throwing = "ex")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex){
        // Print the advised method
        String method = joinPoint.getSignature().toShortString();
        System.out.println(" Executing @AfterThrowing on method: " + method);

        // Print method call results
        System.out.println(" Exception: " + ex);
    }

    @AfterReturning(pointcut = "execution(* com.sazails.afterAdvice.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        // Print the advised method
        String method = joinPoint.getSignature().toShortString();
        System.out.println(" Executing @AfterReturning on method: " + method);

        // Print method call results
        System.out.println(" Result: " + result);

        convertAccountNamesToLowerCase(result);

        // Print modified results
        System.out.println(" Result: " + result);
    }

    private void convertAccountNamesToLowerCase(List<Account> result){
        for(Account account : result){
            account.setUsername(account.getUsername().toLowerCase());
        }
    }
}

