package com.intership.internshipmanagement.service.abstracts;


import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.model.University;
import java.util.List;

public interface UniversityDaoService {

    UniversityDto add(UniversityDto universityDto);
    List<University> getAll();
    List<UniversityDto> getAllDto();
    University getByUniversityId(Long universityId);
    void deleteUniversity(Long universityId);
    UniversityDto getByUniversityDtoId(Long universityId);

}
