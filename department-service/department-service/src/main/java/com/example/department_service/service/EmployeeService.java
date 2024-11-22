package com.example.department_service.service;

import com.example.department_service.entity.EmployeeEntity;
import com.example.department_service.model.EmployeePojo;
import com.example.department_service.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeePojo> getAllEmployee(){
        List<EmployeeEntity> allEmp = employeeRepository.findAll();
        List<EmployeePojo> allPojo = new ArrayList<>();
        allEmp.stream().forEach(EachEmployee ->{
            EmployeePojo empPojo = new EmployeePojo();
            BeanUtils.copyProperties(EachEmployee, empPojo);
            allPojo.add(empPojo);
        });
        return allPojo;
    }

    public EmployeePojo getEmployeeById(long empId){
        Optional<EmployeeEntity> empById = employeeRepository.findById(empId);
        EmployeePojo emp = null;
        if(empById.isPresent()){
            emp = new EmployeePojo();
            BeanUtils.copyProperties(empById.get(), emp);
        }
        return emp;
    }

    public EmployeeEntity addEmployee(EmployeePojo newEmployeePojo) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(newEmployeePojo, employeeEntity);
        employeeRepository.saveAndFlush(employeeEntity);
        return employeeEntity;
    }

    public EmployeeEntity updateEmployee(EmployeePojo editEmployeePojo) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(editEmployeePojo, employeeEntity);
        employeeRepository.saveAndFlush(employeeEntity);
        return employeeEntity;
    }

    public void deleteEmployee(long empId) {
        Optional<EmployeeEntity> fetchEmpEntity = employeeRepository.findById(empId);
        EmployeePojo empPojo = null;
        if (fetchEmpEntity.isPresent()) {
            employeeRepository.delete(fetchEmpEntity.get());
            empPojo = new EmployeePojo();
            BeanUtils.copyProperties(fetchEmpEntity.get(), empPojo);
        }
    }
}
