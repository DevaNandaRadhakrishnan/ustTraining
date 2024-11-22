package com.example.department_service.controller;


import com.example.department_service.entity.EmployeeEntity;
import com.example.department_service.model.EmployeePojo;
import com.example.department_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService empService){
        this.employeeService = empService;
    }

    @GetMapping("/employees")
    public List<EmployeePojo> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{eid}")
    public EmployeePojo getEmployeeById(@PathVariable("eid") long empId){
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/employees")
    public EmployeeEntity addEmployee(@RequestBody EmployeePojo newEmp){
        return employeeService.addEmployee(newEmp);
    }

    @PutMapping("/employees/{did}")
    public EmployeeEntity updateEmployee(@RequestBody EmployeePojo editEmp){
        return  employeeService.updateEmployee(editEmp);
    }

    @DeleteMapping("/employees/{eid}")
    public void removeEmployee(@PathVariable("eid") long empId){
        employeeService.deleteEmployee(empId);
    }
}

