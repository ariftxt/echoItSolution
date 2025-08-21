package com.echoitsolution.first.controller;

import com.echoitsolution.first.entities.UserEntity;
import com.echoitsolution.first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/data/get")
    public String getData(){
        return "Data.....";
    }

    @GetMapping("/user/login")
    public UserEntity publicHello() {
        return userRepository.findByUsername("user").orElse(null);
    }

    @GetMapping("/user/hello")
    public String userHello() {
        return "Hello User (USER or ADMIN)!";
    }

    @GetMapping("/admin/hello")
    public String adminHello() {
        return "Hello Admin!";
    }

    @GetMapping("/get/all")
    public String getAll(){
        return "Data.....";
    }
}
