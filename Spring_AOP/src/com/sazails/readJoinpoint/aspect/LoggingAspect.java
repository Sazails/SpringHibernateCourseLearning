package com.sazails.readJoinpoint.aspect;

import com.sazails.readJoinpoint.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LoggingAspect {

    @Before("AopExpressions.daoPackageNoGetterSetter()")
    public void beforeAddAccountAspect(JoinPoint joinPoint) {
        System.out.println(getClass() + " Executing @Before advice on addAccount()");

        // Display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // Display method arguments
        Object[] args = joinPoint.getArgs();
        for(Object a : args){
            System.out.println(a);

            if(a instanceof Account){
                Account account = (Account) a;
                System.out.println(getClass() + a.toString());
            }
        }
    }
}

