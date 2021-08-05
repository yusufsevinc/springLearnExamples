package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.UniversityDepartmentDto;
import com.intership.internshipmanagement.model.UniversityDepartment;
import java.util.List;

public interface UniversityDepartmentDaoService {
    UniversityDepartmentDto add(UniversityDepartmentDto universityDepartment);
    List<UniversityDepartment> getAll();
    List<UniversityDepartmentDto> getAllDto();
    UniversityDepartment getByUniversityDepartmentId(Long universityDepartmentId);
    void deleteUniversityDepartment(Long universityDepartmentId);
    UniversityDepartmentDto getByUniversityDepartmentDtoId(Long universityDepartmentId);
}
