package com.sazails.afterReturning.aspect;

import com.sazails.afterReturning.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* com.sazails.afterReturning.dao.AccountDAO.findAccounts(..))", returning = "result")
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

