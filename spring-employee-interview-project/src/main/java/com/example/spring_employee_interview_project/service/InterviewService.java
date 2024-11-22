package com.example.spring_employee_interview_project.service;

import com.example.spring_employee_interview_project.entity.Interview;
import com.example.spring_employee_interview_project.entity.Project;
import com.example.spring_employee_interview_project.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    public List<Interview> getFailedInterviewsByProject(Project project) {
        return interviewRepository.findByProjectAndResult(project, "FAIL");
    }
}
