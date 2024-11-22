package com.example.employee_info.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectInfo {

    private int projectId;

    private String projectName;

    private String projectManager;

    private String projectDescription;

    private int teamMembers;

    private String projectStatus;

    private Date projectStartDate;

    private Date projectEndDate;

    private String projectBudget;

    private String companyName;

    private long code;
}