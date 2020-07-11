package com.sazails.aroundAdvice;

import com.sazails.aroundAdvice.dao.AccountDAO;
import com.sazails.aroundAdvice.model.Account;
import com.sazails.aroundAdvice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Get bean from Spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Fortune: " + trafficFortuneService.getFortune());

        // Close context
        context.close();
    }
}
