package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.model.Project;
import com.intership.internshipmanagement.service.concretes.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {


    private final ProjectService projectDaoService;

    public ProjectController(ProjectService projectDaoService) {
        this.projectDaoService = projectDaoService;
    }

    @PostMapping(value = "/add")
    public Project add(@RequestBody Project project) {
        return this.projectDaoService.add(project);

    }

    @GetMapping(value = "/getall")
    public List<Project> getall() {
        return this.projectDaoService.getAll();
    }

    @GetMapping(value = "/getFindProject/{projectId}")
    public Project getByProject(@PathVariable Long projectId) {
        return this.projectDaoService.getByProject(projectId);
    }



    @DeleteMapping(value = "/delete/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        this.projectDaoService.deleteProject(projectId);
    }



}
