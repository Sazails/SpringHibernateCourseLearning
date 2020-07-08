package com.sazails.readJoinpoint;

import com.sazails.readJoinpoint.dao.AccountDAO;
import com.sazails.readJoinpoint.dao.MembershipDAO;
import com.sazails.readJoinpoint.model.Account;
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
        accountDAO.setName("TestSubject");
        accountDAO.setCode("Elite");

        String name = accountDAO.getName();
        String code = accountDAO.getCode();

        membershipDAO.addAccount();

        // Close context
        context.close();
    }
}
