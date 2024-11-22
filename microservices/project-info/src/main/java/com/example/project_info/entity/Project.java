package com.example.project_info.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    private String projectName;

    private String projectManager;

    private String projectDescription;

    private String teamMembers;

    private String projectStatus;

    private Date projectStartDate;

    private Date projectEndDate;

    private String projectBudget;

    private String companyName;

    private long code;
}
