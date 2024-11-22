package com.example.department_service.controller;

import com.example.department_service.service.DepartmentService;
import com.example.department_service.model.DepartmentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService deptService){
        this.departmentService = deptService;
    }

    @GetMapping("/departments")
    public List<DepartmentPojo> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{did}") // Changed to {did}
    public DepartmentPojo getDepartment(@PathVariable("did") long deptId){
        return departmentService.getDepartment(deptId);
    }

    @PostMapping("/departments") // For adding a new department
    public DepartmentPojo addDepartment(@RequestBody DepartmentPojo newDept){
        return departmentService.addDepartment(newDept);
    }

    @PutMapping("/departments/{did}") // Changed to PUT and included {did}
    public DepartmentPojo updateDepartment(@RequestBody DepartmentPojo editDept){
        return  departmentService.updateDepartment(editDept);
    }

    @DeleteMapping("/departments/{did}") // Changed to {did}
    public void removeDepartment(@PathVariable("did") long deptId){
        departmentService.deleteDepartment(deptId);
    }
}
