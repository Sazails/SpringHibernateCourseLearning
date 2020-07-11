package com.sazails.aroundAdviceHandleException.dao;

import com.sazails.aroundAdviceHandleException.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String code;

    public List<Account> findAccounts(boolean giveError){
        if(giveError){
            throw new RuntimeException("GiveError set to true!");
        }

        List<Account> accounts = new ArrayList<>();

        // Sample accounts
        accounts.add(new Account("Denis", 87));
        accounts.add(new Account("Mary", 79));
        accounts.add(new Account("Lauren", 95));

        return accounts;
    }

    public String getName() {
        System.out.println(getClass() + " called getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " called setName()");
        this.name = name;
    }

    public String getCode() {
        System.out.println(getClass() + " called getServiceCode()");
        return code;
    }

    public void setCode(String code) {
        System.out.println(getClass() + " called setServiceCode()");
        this.code = code;
    }

    public void addAccount(Account account, boolean vip){
        System.out.println(getClass() + " ADDING ACCOUNT: " + account.toString());
    }

    public void updateAccount() { System.out.println(getClass() + " UPDATING ACCOUNT"); }


}
