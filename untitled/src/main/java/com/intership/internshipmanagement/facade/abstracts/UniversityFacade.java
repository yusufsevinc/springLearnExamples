package com.intership.internshipmanagement.facade.abstracts;

import com.intership.internshipmanagement.model.University;

import java.util.List;

public interface UniversityFacade {


    void add(University university);

    List<University> getAll();

    University getByUniversityId(Long universityId);

    void deleteUniversity(Long universityId);
}
