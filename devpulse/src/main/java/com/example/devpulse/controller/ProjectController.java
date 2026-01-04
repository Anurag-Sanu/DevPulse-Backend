package com.example.devpulse.controller;

import com.example.devpulse.entity.Project;
import com.example.devpulse.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // 1. Create a Project (POST)
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    // 2. Get all Projects (GET)
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
