package com.example.department_service.service;

import com.example.department_service.model.DepartmentPojo;

import java.util.List;

public interface DepartmentService {
    List<DepartmentPojo> getAllDepartments();
    DepartmentPojo getDepartment(long deptId);
    DepartmentPojo addDepartment(DepartmentPojo newDepartmentPojo);
    DepartmentPojo updateDepartment(DepartmentPojo editDepartmentPojo);
    void deleteDepartment(long deptId);
}
