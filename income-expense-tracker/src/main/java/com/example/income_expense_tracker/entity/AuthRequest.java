package com.example.income_expense_tracker.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="auth_request")
public class AuthRequest {

    private String username ;
    private String password;
}
