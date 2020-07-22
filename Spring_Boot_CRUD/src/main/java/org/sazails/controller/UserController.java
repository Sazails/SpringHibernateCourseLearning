package org.sazails.controller;

import org.sazails.entity.User;
import org.sazails.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/list_users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "users/user_form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int id, Model model){
        User user = userService.find(id);
        model.addAttribute("user", user);
        return "users/user_form";
    }

    @PostMapping("save")
    public String saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int id){
        userService.delete(id);
        return "redirect:/users/list";
    }
}
