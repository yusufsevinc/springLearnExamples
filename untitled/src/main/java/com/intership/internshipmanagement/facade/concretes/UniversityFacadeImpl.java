package com.intership.internshipmanagement.facade.concretes;

import com.intership.internshipmanagement.facade.abstracts.UniversityFacade;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.service.abstracts.UniversityService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityFacadeImpl implements UniversityFacade {

    private final UniversityService universityService;

    @Override
    public void add(University university){
        universityService.add(university);
    }

    @Override
    public List<University> getAll() {
        return this.universityService.getAll();
    }

    @Override
    public University getByUniversityId(Long universityId) {
            return this.universityService.getByUniversityId(universityId);

    }
    @Override
    public void deleteUniversity(Long universityId) {
            this.universityService.deleteUniversity(universityId);


    }


}
