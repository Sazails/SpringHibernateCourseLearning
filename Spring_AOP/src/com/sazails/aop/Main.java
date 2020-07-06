package com.sazails.aop;

import com.sazails.aop.dao.AccountDAO;
import com.sazails.aop.dao.MembershipDAO;
import com.sazails.aop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Get bean from Spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // Create Account
        Account account = new Account("ProGrammar", 96);

        // Call business method
        accountDAO.addAccount(account, true);
        accountDAO.updateAccount();
        System.out.println(accountDAO.getAccount());
        System.out.println(accountDAO.isOnline(true));

        membershipDAO.addAccount();

        // Close context
        context.close();
    }
}
