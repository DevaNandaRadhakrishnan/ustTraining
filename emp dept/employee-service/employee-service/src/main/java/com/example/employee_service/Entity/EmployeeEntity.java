package com.example.employee_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee_details")
public class EmployeeEntity {
    @Id
    @Column(name = "emp_id")
    private long empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_email")
    private String empEmail;

    @Column(name = "dept_id")
    private long deptId;

}


