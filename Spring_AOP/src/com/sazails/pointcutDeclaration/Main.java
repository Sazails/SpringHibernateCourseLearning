package com.sazails.pointcutDeclaration;

import com.sazails.pointcutDeclaration.dao.AccountDAO;
import com.sazails.pointcutDeclaration.dao.MembershipDAO;
import com.sazails.pointcutDeclaration.model.Account;
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

        membershipDAO.addAccount();

        // Close context
        context.close();
    }
}
