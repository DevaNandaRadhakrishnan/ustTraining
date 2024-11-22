package com.example.authentication_service.service;

import com.example.authentication_service.entity.UserCredentialsEntity;
import com.example.authentication_service.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    UserCredentialsRepository authDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserCredentialsEntity register(UserCredentialsEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authDao.saveAndFlush(user);
    }
}

