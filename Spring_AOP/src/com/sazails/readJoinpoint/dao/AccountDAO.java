package com.sazails.readJoinpoint.dao;

import com.sazails.readJoinpoint.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String code;

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
