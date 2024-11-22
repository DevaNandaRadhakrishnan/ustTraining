package com.example.project_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectInfoApplication.class, args);
	}

}
