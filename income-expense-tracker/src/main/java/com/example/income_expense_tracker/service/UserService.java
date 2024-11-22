package com.example.income_expense_tracker.service;

import com.example.income_expense_tracker.entity.UserInfo;
import com.example.income_expense_tracker.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repo.save(userInfo);
        return "user added to system ";
    }
}
