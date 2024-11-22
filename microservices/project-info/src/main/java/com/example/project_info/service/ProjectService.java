package com.example.project_info.service;

import com.example.project_info.dto.ProjectDto;
import com.example.project_info.entity.Project;
import com.example.project_info.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project){
        Project project1 = new Project();
        project1.setProjectName(project.getProjectName());
        project1.setProjectDescription(project.getProjectDescription());
        project1.setTeamMembers(project.getTeamMembers());
        project1.setProjectStatus(project.getProjectStatus());
        project1.setProjectStartDate(project.getProjectStartDate());
        project1.setProjectEndDate(project.getProjectEndDate());
        project1.setProjectBudget(project.getProjectBudget());
        project1.setCompanyName(project.getCompanyName());
        project1.setProjectManager(project.getProjectManager());
        project1.setCompanyName(project.getCompanyName());
        project1.setCode(project.getCode());

        return projectRepository.save(project);
    }
    public Project updateProject(int id, Project project){
        Project existingProject = projectRepository.findById((long) id).get();
        return projectRepository.save(project);
    }
    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }
    public Project getProject(Long id){
        return projectRepository.findById(id).get();
    }

    public List<Project> getProjectByCode(long code) {
        return projectRepository.findByCode(code);
    }
}
