package com.example.employee_info.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class EmployeeInfo {
    @Id
    private long code;
    private String name;
    private String department;
    private String designation;
    private List<String> skills;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int exp;
    private String doj;


}
