package com.hansei.demo.controller;


import com.hansei.demo.entity.User;
import com.hansei.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping("user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserId(id);
    }


    @GetMapping("user/{id}")
    public User getUserByName(@RequestBody String name) {
        return userService.getUserName(name);
    }
}
