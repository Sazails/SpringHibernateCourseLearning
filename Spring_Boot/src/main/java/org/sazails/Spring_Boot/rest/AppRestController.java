package org.sazails.Spring_Boot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppRestController {

    @Value("${test.id}")
    private int testId;

    @Value("${test.username}")
    private String testUsername;

    @GetMapping("/")
    public String sayHello(){
        return "Hello!";
    }

    @GetMapping("/randomNumber/{minNumber} {maxNumber}")
    public String getRandomNumber(@PathVariable double minNumber, @PathVariable double maxNumber){
        return Double.toString((Math.random()*((maxNumber-minNumber)+1))+minNumber);
    }

    @GetMapping("/testInfo")
    public String getTestInfo(){
        return "ID: " + testId + ", USERNAME: " + testUsername;
    }
}
