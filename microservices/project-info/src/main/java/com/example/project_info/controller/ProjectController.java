package com.example.project_info.controller;

import com.example.project_info.entity.Project;
import com.example.project_info.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/addProject")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        return new ResponseEntity<>(projectService.addProject(project),HttpStatus.CREATED);
    }

    @GetMapping("/getProject")
    public ResponseEntity<Project> getProject(@RequestParam Long projectId){
        return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.OK);
    }

    @GetMapping("/getProject/{code}")
    public ResponseEntity<List<Project>> getProjectByCode(@PathVariable long code){
        return new ResponseEntity<>(projectService.getProjectByCode(code), HttpStatus.OK);
    }
}
