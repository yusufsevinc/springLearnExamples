package com.intership.internshipmanagement.repositorys;

import com.intership.internshipmanagement.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project getByProjectId(Long projectId);


}
