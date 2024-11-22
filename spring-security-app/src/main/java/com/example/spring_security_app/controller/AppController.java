package com.example.spring_security_app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/home")
    public String home() {
        return "Welcome to Home Page";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Welcome to Admin Page";
    }
}
