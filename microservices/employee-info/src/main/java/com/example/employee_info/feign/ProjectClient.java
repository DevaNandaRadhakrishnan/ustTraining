package com.example.employee_info.feign;

import com.example.employee_info.client.ProjectInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "project-info", url = "http://localhost:8081/api/projects")
public interface ProjectClient {
    @GetMapping("getProject/{code}")
    List<ProjectInfo> findProjectByCode(@PathVariable("code") Long code);
}
