package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.repository.UniversityDegreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityDegreeService {
     private final UniversityDegreeRepository universityDegreeRepository;

    public UniversityDegreeService(UniversityDegreeRepository universityDegreeRepository) {
        this.universityDegreeRepository = universityDegreeRepository;
    }

    public UniversityDegree getByDegree(Long universityDegreId){
        return universityDegreeRepository.findById(universityDegreId).orElseThrow(
                () -> new NotFoundException(Message.errorTeacherAdding));
    }

    public List<UniversityDegree> getAll(){
        return this.universityDegreeRepository.findAll();
    }
}
