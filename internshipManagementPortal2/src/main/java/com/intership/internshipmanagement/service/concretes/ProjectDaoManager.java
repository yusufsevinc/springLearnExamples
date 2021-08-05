package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.model.Project;
import com.intership.internshipmanagement.repository.ProjectRepository;
import com.intership.internshipmanagement.service.abstracts.ProjectDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDaoManager implements ProjectDaoService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project add(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return this.projectRepository.findAll();
    }



    @Override
    public Project getByProject(Long projectId) {
        boolean isExist = this.projectRepository.existsById(projectId);
        if (isExist) {
            return this.projectRepository.getByProjectId(projectId);
        } else{
            throw new InternalServerError(Message.errorProjectGetById);
        }

    }

    @Override
    public void deleteProject(Long projectId) {
        boolean isExist = this.projectRepository.existsById(projectId);

        if (isExist) {
            this.projectRepository.deleteById(projectId);
        } else{
            throw new InternalServerError(Message.errorProjectGetById);
        }
    }


}
