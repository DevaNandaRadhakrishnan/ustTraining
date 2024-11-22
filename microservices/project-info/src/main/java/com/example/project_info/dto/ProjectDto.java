package com.example.project_info.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public class ProjectDto {

    @NotNull(message = "Project Name cannot be null")
    private String projectName;

    @NotNull(message = "Project description cannot be null")
    @Size(min=20, max=200, message = "project description ")
    private String projectDescription;

    @NotNull(message = "Project manager cannot be null")
    private String projectManager;

    @NotNull(message = "Project team members cannot be null")
    private String teamMembers;

    @NotNull(message = "Project Status cannot be null")
    private String projectStatus;

    @NotNull(message = "Project start date cannot be null")
    private Date projectStartDate;

    @NotNull(message = "Project end date cannot be null")
    private Date projectEndDate;

    @NotNull(message = "Project Budget cannot be null")
    private String projectBudget;

    @NotNull(message = "Company name cannot be null")
    private String companyName;

    @NotNull(message = "Code cannot be null")
    private long code;
}
