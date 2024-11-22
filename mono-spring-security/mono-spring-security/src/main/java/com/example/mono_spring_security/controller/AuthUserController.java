package com.example.mono_spring_security.controller;

import com.example.mono_spring_security.entity.AuthUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthUserController {
    @PostMapping("/authuser/validator")
    public AuthUser validate(@RequestBody AuthUser user){
        return null;
    }
}
