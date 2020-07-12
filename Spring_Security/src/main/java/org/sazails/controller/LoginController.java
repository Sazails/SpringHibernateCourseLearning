package org.sazails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){ return "fancy_login"; }

    @GetMapping("/access_denied")
    public String showAccessDeniedPage(){ return "access_denied"; }
}
