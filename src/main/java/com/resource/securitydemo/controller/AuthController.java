package com.resource.securitydemo.controller;

import com.resource.securitydemo.models.LoginRequest;
import com.resource.securitydemo.models.LoginResponse;
import com.resource.securitydemo.service.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private KeycloakService keycloakService;

    @GetMapping("/login")
    public LoginResponse authenticateUser(@RequestParam String username, @RequestParam String password){
        return keycloakService.authenticateUser(new LoginRequest(username, password));
    }

    @GetMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String password){
        return "Not implemented yet, please try again later";
    }
}
