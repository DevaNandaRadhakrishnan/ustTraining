package com.example.spring_employee_interview_project.service;

import com.example.spring_employee_interview_project.entity.Employee;
import com.example.spring_employee_interview_project.entity.Project;
import com.example.spring_employee_interview_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByProject(Project project) {
        return employeeRepository.findByProject(project);
    }
}
