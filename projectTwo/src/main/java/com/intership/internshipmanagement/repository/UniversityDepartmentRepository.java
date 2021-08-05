package com.intership.internshipmanagement.repository;

import com.intership.internshipmanagement.dto.UniversityDepartmentDto;
import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityDepartmentRepository extends JpaRepository<UniversityDepartment, Long> {
    UniversityDepartment getByUniversityDepartmentId(Long universityDepartmentId);
    @Query("select new com.intership.internshipmanagement.dto.UniversityDepartmentDto(u.universityDepartmentId , u.universityDepartmentName) from UniversityDepartment  u")
    List<UniversityDepartmentDto> getAllDto();
}
