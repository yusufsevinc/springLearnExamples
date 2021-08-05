package com.intership.internshipmanagement.controllers;

import com.intership.internshipmanagement.models.Project;
import com.intership.internshipmanagement.services.abstracts.ProjectDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private  ProjectDaoService projectDaoService;

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
