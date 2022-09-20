package com.kangs.lotus.controller;

import com.kangs.lotus.model.User;
import com.kangs.lotus.services.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user/")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String userSave(@RequestBody User user){
        return userService.userSave(user);
    }

    @GetMapping("/signIn")
    public User signIn(@RequestParam String email,@RequestParam String password) throws Exception {
        return userService.signIn(email,password);
    }

    @GetMapping(path = "/getAllCustomer")
    public List<User> getAllCustomer(){
        return userService.getAllCustomer();
    }

    
}
