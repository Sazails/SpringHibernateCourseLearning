package org.sazails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/admins")
    public String showAdmins() { return "admins"; }

    @GetMapping("/specials")
    public String showSpecials() { return "specials"; }
}
