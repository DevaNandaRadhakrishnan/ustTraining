package com.example.employee_info.controller;

import com.example.employee_info.client.FullResponses;
import com.example.employee_info.entity.EmployeeInfo;
import com.example.employee_info.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ustemps")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @PostMapping("/add")
    public EmployeeInfo addEmployee(@RequestBody EmployeeInfo employee) {
        return service.saveEmployee(employee);
    }
    @GetMapping("/withprojects/{code}")
    public ResponseEntity<FullResponses> getEmployeesByCode(@PathVariable("code") Long code) {
        return ResponseEntity.ok(service.getEmployeesByProjectCode(code));

    }
}
