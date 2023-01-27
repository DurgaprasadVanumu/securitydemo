package com.resource.securitydemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@CrossOrigin(value = "*")
public class ResourceController {

    @GetMapping("/admin/getMessage")
    @RolesAllowed(value = {"ADMIN"})
    public String adminMessage(){
        return "Hello from Admin API";
    }

    @GetMapping("/user/getMessage")
    @RolesAllowed(value = {"USER"})
    public String userMessage(){
        return "Hello from User API";
    }

    @GetMapping("/common/getMessage")
    @RolesAllowed(value = {"USER", "ADMIN"})
    public String commonMessage(){
        return "Hello from common API";
    }
}
