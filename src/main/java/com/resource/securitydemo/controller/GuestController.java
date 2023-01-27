package com.resource.securitydemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/guest")
public class GuestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello There!";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to my world!";
    }
}
