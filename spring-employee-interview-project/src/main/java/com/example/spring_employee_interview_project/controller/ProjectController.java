package com.example.spring_employee_interview_project.controller;

import com.example.spring_employee_interview_project.entity.Employee;
import com.example.spring_employee_interview_project.entity.Interview;
import com.example.spring_employee_interview_project.entity.Project;
import com.example.spring_employee_interview_project.repository.ProjectRepository;
import com.example.spring_employee_interview_project.service.EmployeeService;
import com.example.spring_employee_interview_project.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/employees/{id}")
    public ResponseEntity<List<Employee>> getEmployeesByProject(@PathVariable Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            List<Employee> employees = employeeService.getEmployeesByProject(optionalProject.get());
            return ResponseEntity.ok(employees);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/interview-failures/{id}")
    public ResponseEntity<List<Interview>> getFailedInterviews(@PathVariable Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            List<Interview> failedInterviews = interviewService.getFailedInterviewsByProject(optionalProject.get());
            return ResponseEntity.ok(failedInterviews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
