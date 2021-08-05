package com.intership.internshipmanagement.repository;

import com.intership.internshipmanagement.dto.DepartmentDto;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select new com.intership.internshipmanagement.dto.DepartmentDto(d.departmentName) from Department  d")
    List<DepartmentDto> departmentDetails();

}
