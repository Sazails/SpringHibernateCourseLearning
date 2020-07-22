package org.sazails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/test")
    public String doTest(Model model){
        model.addAttribute("_time", new java.util.Date());
        return "test";
    }
}
