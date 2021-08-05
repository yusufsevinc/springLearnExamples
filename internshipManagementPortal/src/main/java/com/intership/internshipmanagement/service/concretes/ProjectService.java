package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.model.Project;
import com.intership.internshipmanagement.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService{

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

  
    public Project add(Project project) {
        return this.projectRepository.save(project);
    }

  
    public List<Project> getAll() {
        return this.projectRepository.findAll();
    }



  
    public Project getByProject(Long projectId) {
        boolean isExist = this.projectRepository.existsById(projectId);
        if (isExist) {
            return this.projectRepository.getByProjectId(projectId);
        } else{
            throw new InternalServerError(Message.errorProjectGetById);
        }

    }

  
    public void deleteProject(Long projectId) {
        boolean isExist = this.projectRepository.existsById(projectId);

        if (isExist) {
            this.projectRepository.deleteById(projectId);
        } else{
            throw new InternalServerError(Message.errorProjectGetById);
        }
    }


}
