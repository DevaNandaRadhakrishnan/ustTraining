package com.ust.Employeeinfo.fegin;

import com.ust.Employeeinfo.client.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Projectinfo", url="http://localhost:9091/project")
public interface Projectclient {
       @GetMapping("/project/{ccode}")
        Project findProjectsByCcode(@PathVariable("ccode") Long ccode);
    }

