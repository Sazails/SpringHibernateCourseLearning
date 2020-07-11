package com.sazails.aroundAdviceHandleException.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Today's the traffic day!";
    }

    public String getFortune(boolean giveError){
        if(giveError){
            throw new RuntimeException("GiveError is on!");
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getFortune();
    }
}
