package com.example.income_expense_tracker.controller;

import com.example.income_expense_tracker.entity.AuthRequest;
import com.example.income_expense_tracker.entity.Expense;
import com.example.income_expense_tracker.service.ExpenseService;
import com.example.income_expense_tracker.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getBalance/date")
    public ResponseEntity<Double> getBalanceByDate(@RequestParam("date") Date date) {
        double balance = expenseService.getBalanceByDate(date);
        return ResponseEntity.ok(balance);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/getExpense/payment-method")
    public ResponseEntity<Double> getExpenseByPaymentMethod(@RequestParam("paymentMethod") String paymentMethod) {
        double balance = expenseService.getExpenseByPaymentMethod(paymentMethod);
        return ResponseEntity.ok(balance);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) {
        Expense createdExpense = expenseService.addExpense(expense);
        return ResponseEntity.status(200).body(createdExpense);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
}

