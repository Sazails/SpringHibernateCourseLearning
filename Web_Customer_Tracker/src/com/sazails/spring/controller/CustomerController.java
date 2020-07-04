package com.sazails.spring.controller;

import com.sazails.spring.dao.CustomerDAO;
import com.sazails.spring.entity.Customer;
import com.sazails.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Inject customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/list")
    public String listCustomers(Model model){
        // Get customers from service
        List<Customer> customers = customerService.getCustomers();

        // Add customers to model
        model.addAttribute("customers", customers);

        return "list-customers";
    }

}
