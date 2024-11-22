package com.example.department_service.controller;

import com.example.department_service.model.EmployeePojo;
import com.example.department_service.service.DepartmentService;
import com.example.department_service.model.DepartmentPojo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;

    public static  final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    public DepartmentController(DepartmentService deptService){
        this.departmentService = deptService;
    }

    @GetMapping("/departments")
    public List<DepartmentPojo> getAllDepartments(){
        LOG.info("in getAllDepartment()");
        return departmentService.getAllDepartments();
    }

    @CircuitBreaker(name="ciremp", fallbackMethod = "fallbackEmployee")
    @GetMapping("/departments/{did}")
    public DepartmentPojo getDepartment(@PathVariable("did") long deptId){
        DepartmentPojo deptPojo = departmentService.getDepartment(deptId);
        RestClient restClient = RestClient.create();
        List<EmployeePojo> allEmps = restClient
                .get()
                .uri("http://localhost:8086/api/employees/departments/" + deptId)
                .retrieve()
                .body(List.class);
        deptPojo.setAllEmployees(allEmps);
        return deptPojo;
    }

    public DepartmentPojo fallbackEmployee() {
        return new DepartmentPojo(0, "fallback", null);
    }


    @PostMapping("/departments")
    public DepartmentPojo addDepartment(@RequestBody DepartmentPojo newDept){
        LOG.info("in addDepartment()");
        return departmentService.addDepartment(newDept);
    }

    @PutMapping("/departments/{did}")
    public DepartmentPojo updateDepartment(@RequestBody DepartmentPojo editDept){
        LOG.info("in updateDepartment()");
        return  departmentService.updateDepartment(editDept);
    }

    @DeleteMapping("/departments/{did}")
    public void removeDepartment(@PathVariable("did") long deptId){
        LOG.info("in removeDepartment()");
        departmentService.deleteDepartment(deptId);
    }
}
