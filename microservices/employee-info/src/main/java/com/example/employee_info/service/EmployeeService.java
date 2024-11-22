package com.example.employee_info.service;

import com.example.employee_info.client.FullResponses;
import com.example.employee_info.client.ProjectInfo;
import com.example.employee_info.entity.EmployeeInfo;
import com.example.employee_info.feign.ProjectClient;
import com.example.employee_info.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private ProjectClient client;

    public EmployeeInfo saveEmployee(EmployeeInfo employee) {

        return repo.save(employee);
    }

    public FullResponses getEmployeesByProjectCode(Long code) {
        EmployeeInfo employee =repo.findByCode(code);
        List<ProjectInfo> pro=client.findProjectByCode(code);
        FullResponses response = new FullResponses();
        assert employee != null;
        response.setName(employee.getName());
        response.setDepartment(employee.getDepartment());
        response.setDesignation(employee.getDesignation());
        response.setCode(employee.getCode());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setAddress(employee.getAddress());
        response.setCity(employee.getCity());
        response.setState(employee.getState());
        response.setExp(employee.getExp());
        response.setDoj(employee.getDoj());
        response.setSkills(employee.getSkills());
        response.setProjects(pro);
        return response;
    }
}
