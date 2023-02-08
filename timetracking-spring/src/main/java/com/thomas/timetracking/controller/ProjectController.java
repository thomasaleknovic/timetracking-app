package com.thomas.timetracking.controller;


import com.thomas.timetracking.model.Project;
import com.thomas.timetracking.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Get all projects
    @GetMapping
    public List<Project> list() {
        return projectRepository.findAll();
    }

    // Get a project by its Id
    @GetMapping("/{id}")
    public Optional<Project> getById(@PathVariable Long id) {
        return projectRepository.findById(id);
    }


    // Create a new project
    @PostMapping
    public Project create(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    // Update project name
    @PutMapping("/{id}")
    public Optional<Project> update(@PathVariable Long id, @RequestBody Project project){
         return projectRepository.findById(id).map(recordFound -> {
             recordFound.setName(project.getName());
             return projectRepository.save(recordFound);
         });


    }






}
