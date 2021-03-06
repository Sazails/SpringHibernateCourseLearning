package org.sazails.rest;

import org.sazails.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private List<User> users;

    @PostConstruct
    public void loadUsersData(){
        users = new ArrayList<>();
        users.add(new User(1, "TestUser", "Lion"));
        users.add(new User(2, "TestUser2", "Goat"));
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        for(User user : users){
            if(userId == user.getId()){
                return user;
            }
        }
        throw new UserNotFoundException("User id not found: " + userId);
    }
}
