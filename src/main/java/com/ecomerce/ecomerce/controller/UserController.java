package com.ecomerce.ecomerce.controller;

import com.ecomerce.ecomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecomerce.ecomerce.model.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/e-comerce")
public class UserController {

    @Autowired
    UserService service;

    @PutMapping("/api/config/user/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody  User user) {
        return service.updateUser(user, id);
    }
//
//
//    @PostMapping("/user")
//    public User createUser(@RequestBody User user) {
//        return service.createUser(user);
//    }
//
//    @GetMapping("/user/all")
//    public List<User> findUsers() {
//        return service.findAll();
//    }
//
//    @GetMapping("/user")
//    public User findByName(@RequestParam String name) {
//        return service.findByName(name);
//    }
//
//    @PutMapping("/user/{id}")
//    public User updateUserById(@PathVariable Long id, @RequestBody  User user) {
//        return service.updateUserById(user, id);
//    }

}
