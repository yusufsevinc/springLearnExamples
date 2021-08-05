package com.intership.internshipmanagement.services.abstracts;


import com.intership.internshipmanagement.models.Project;

import java.util.List;

public interface ProjectDaoService {
    Project add(Project project);
    List<Project> getAll();
    Project getByProject(Long projectId);
    void deleteProject(Long projectId);
}
