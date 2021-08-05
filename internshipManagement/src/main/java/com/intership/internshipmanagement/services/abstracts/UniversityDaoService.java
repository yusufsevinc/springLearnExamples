package com.intership.internshipmanagement.services.abstracts;


import com.intership.internshipmanagement.dtos.UniversityDto;
import com.intership.internshipmanagement.models.University;
import java.util.List;

public interface UniversityDaoService {

    UniversityDto add(UniversityDto universityDto);
    List<University> getAll();
    List<UniversityDto> getAllDto();
    University getByUniversityId(Long universityId);
    void deleteUniversity(Long universityId);
    UniversityDto getByUniversityDtoId(Long universityId);

}
