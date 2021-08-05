package com.intership.internshipmanagement.service.abstracts;


import com.intership.internshipmanagement.model.Project;

import java.util.List;

public interface ProjectDaoService {
    Project add(Project project);
    List<Project> getAll();
    Project getByProject(Long projectId);
    void deleteProject(Long projectId);
}
