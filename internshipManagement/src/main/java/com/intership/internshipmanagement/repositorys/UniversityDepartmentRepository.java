package com.intership.internshipmanagement.repositorys;

import com.intership.internshipmanagement.dtos.UniversityDepartmentDto;
import com.intership.internshipmanagement.models.UniversityDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityDepartmentRepository extends JpaRepository<UniversityDepartment, Long> {
    UniversityDepartment getByUniversityDepartmentId(Long universityDepartmentId);
    @Query("select new com.intership.internshipmanagement.dtos.UniversityDepartmentDto(u.universityDepartmentId , u.universityDepartmentName) from UniversityDepartment  u")
    List<UniversityDepartmentDto> getAllDto();
}
