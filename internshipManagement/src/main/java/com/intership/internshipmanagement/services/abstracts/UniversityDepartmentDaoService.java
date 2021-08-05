package com.intership.internshipmanagement.services.abstracts;

import com.intership.internshipmanagement.dtos.UniversityDepartmentDto;
import com.intership.internshipmanagement.models.UniversityDepartment;
import java.util.List;

public interface UniversityDepartmentDaoService {
    UniversityDepartmentDto add(UniversityDepartmentDto universityDepartment);
    List<UniversityDepartment> getAll();
    List<UniversityDepartmentDto> getAllDto();
    UniversityDepartment getByUniversityDepartmentId(Long universityDepartmentId);
    void deleteUniversityDepartment(Long universityDepartmentId);
    UniversityDepartmentDto getByUniversityDepartmentDtoId(Long universityDepartmentId);
}
