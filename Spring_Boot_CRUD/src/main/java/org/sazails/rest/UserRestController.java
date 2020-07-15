package org.sazails.rest;

import org.sazails.entity.User;
import org.sazails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService service){
        userService = service;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.find(userId);
        if(user == null){
            throw new RuntimeException("User with id '" + userId + "' not found!");
        }
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setId(0); // 0 - forces creation of new user
        userService.save(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User user = userService.find(userId);
        if(user == null){
            throw new RuntimeException("User with id '" + userId + "' not found!");
        }

        userService.delete(userId);
        return "Deleted user with id '" + userId + "'!";
    }
}
