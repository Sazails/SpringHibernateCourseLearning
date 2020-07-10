package com.sazails.aopBasics.dao;

import com.sazails.aopBasics.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vip){
        System.out.println(getClass() + " ADDING ACCOUNT: " + account.toString());
    }

    public void updateAccount() { System.out.println(getClass() + " UPDATING ACCOUNT"); }

    public String getAccount(){
        return "ACCOUNT[TEST]";
    }

    public boolean isOnline(boolean printState){
        if(printState){
            System.out.println(getClass() + " ACCOUNT:[TEST] IS ONLINE");
        }
        return true;
    }
}
