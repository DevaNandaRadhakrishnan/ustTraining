package com.example.employee_service.controller;

import com.example.employee_service.Entity.EmployeeEntity;
import com.example.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    public static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    EmployeeRepository empRepo;

    @Autowired
    public EmployeeController(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployees(){
        return empRepo.findAll();
    }

    @GetMapping("/employees/departments/{did}")
    public List<EmployeeEntity> getAllEmployeesByDepartment(@PathVariable long did){
        return empRepo.findByDeptId(did);
    }

    @PostMapping("/employees")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity newEmp) {
        return empRepo.saveAndFlush(newEmp);
    }
}