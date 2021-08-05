package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.dto.DepartmentDto;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.Department;

import java.util.List;

public interface DepartmentDaoService {

    DepartmentDto add(DepartmentDto departmentDto);
    List<Department> getAll();
    DepartmentDto getByDepartment(Long departmentId);
    List<DepartmentDto> departmentDetails();
    void deleteDepartment(Long departmentId);
}
