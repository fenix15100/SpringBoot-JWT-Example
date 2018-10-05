package com.fenix15100.springbootjwt.controller;

import com.fenix15100.springbootjwt.model.User;
import com.fenix15100.springbootjwt.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String regiterUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/get")
    public User getUser(HttpServletRequest request) {
        ObjectId userId = (ObjectId) request.getAttribute("userId");
        return userService.getUser(userId);
    }



}
