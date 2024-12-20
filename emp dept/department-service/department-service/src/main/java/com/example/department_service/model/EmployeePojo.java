package com.example.department_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeePojo {
    private long empId;
    private String empName;
    private String empEmail;
    private long deptId;
}
