package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.model.University;

import java.util.List;

public interface UniversityService {

    void save(University universityDto);
    List<University> getAll();
    University getByUniversityId(Long universityId);


    void deleteUniversity(Long universityId);
}
