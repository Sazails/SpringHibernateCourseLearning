package com.sazails.afterAdvice;

import com.sazails.afterAdvice.dao.AccountDAO;
import com.sazails.afterAdvice.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Get bean from Spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // Call find accounts method and display
        List<Account> accounts = null;
        try{
            accounts = accountDAO.findAccounts(true);
        }catch(Exception ex){
            System.out.println("Caught exception: " + ex);
        }
        System.out.println(accounts);

        // Close context
        context.close();
    }
}
