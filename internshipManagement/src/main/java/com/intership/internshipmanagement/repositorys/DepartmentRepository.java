package com.intership.internshipmanagement.repositorys;

import com.intership.internshipmanagement.dtos.DepartmentDto;
import com.intership.internshipmanagement.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select new com.intership.internshipmanagement.dtos.DepartmentDto(d.departmentName) from Department  d")
    List<DepartmentDto> departmentDetails();

}
