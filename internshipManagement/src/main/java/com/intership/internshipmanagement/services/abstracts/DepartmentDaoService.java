package com.intership.internshipmanagement.services.abstracts;

import com.intership.internshipmanagement.dtos.DepartmentDto;
import com.intership.internshipmanagement.models.Department;

import java.util.List;

public interface DepartmentDaoService {

    DepartmentDto add(DepartmentDto departmentDto);
    List<Department> getAll();
    DepartmentDto getByDepartment(Long departmentId);
    List<DepartmentDto> departmentDetails();
    void deleteDepartment(Long departmentId);
}
