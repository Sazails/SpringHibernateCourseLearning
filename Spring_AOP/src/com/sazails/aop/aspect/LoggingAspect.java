package com.sazails.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(public void com.sazails.aop.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(void add*())")
//    @Before("execution(public void com.sazails.aop.dao.AccountDAO.*Account())")
//    @Before("execution(public String com.sazails.aop.dao.AccountDAO.*Account())")
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void addAccount(com.sazails.aop.model.Account))")
//    @Before("execution(public void addAccount(com.sazails.aop.model.Account, ..))") // ".." means any number of arguments, while "*" means one argument.
//    @Before("execution(public void addAccount(..))")
    @Before("execution(* com.sazails.aop.dao.*.*(..))")
    public void beforeAddAccountAspect(){
        System.out.println(getClass() + " Executing @Before advice on addAccount()");
    }
}
