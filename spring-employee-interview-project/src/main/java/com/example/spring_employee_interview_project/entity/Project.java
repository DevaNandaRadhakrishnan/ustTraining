package com.example.spring_employee_interview_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor

public class Project {
    @Id
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String name;

    @Column(name = "project_description")
    private String description;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Interview> interviews;

}
