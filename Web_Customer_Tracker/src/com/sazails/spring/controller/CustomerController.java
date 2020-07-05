package com.sazails.spring.controller;

import com.sazails.spring.entity.Customer;
import com.sazails.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "list_customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer_form";
    }

    // Takes the "saveCustomer" action from "form:form action="saveCustomer" in "customer_form.jsp"
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        // Save customer using service
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
        // Get customer from service
        Customer customer = customerService.getCustomer(id);

        // Pre-populate form with chosen customer
        model.addAttribute("customer", customer);

        return "customer_form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id){
        // Delete customer
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("searchName") String searchName, Model model){
        // Search customers from service
        List<Customer> customers = customerService.searchCustomers(searchName);

        // Add customers to model
        model.addAttribute("customers", customers);

        return "list_customers";
    }
}
