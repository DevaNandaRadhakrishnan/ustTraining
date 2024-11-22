package com.example.spring_employee_interview_project.repository;

import com.example.spring_employee_interview_project.entity.Interview;
import com.example.spring_employee_interview_project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByProjectAndResult(Project project, String result);
}
