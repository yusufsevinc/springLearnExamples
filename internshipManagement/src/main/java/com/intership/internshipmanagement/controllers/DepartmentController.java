package com.intership.internshipmanagement.controllers;

import com.intership.internshipmanagement.dtos.DepartmentDto;
import com.intership.internshipmanagement.models.Department;
import com.intership.internshipmanagement.services.abstracts.DepartmentDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentDaoService departmentDaoService;

    @PostMapping(value = "/add")
    public DepartmentDto add(@RequestBody DepartmentDto departmentDto) {
        return this.departmentDaoService.add(departmentDto);
    }

    @GetMapping(value = "/getAll")
    public List<Department> getall(){
        return this.departmentDaoService.getAll();
    }

    @GetMapping(value = "/getAllDepartmentDetails")
    public List<DepartmentDto> departmentDetails(){
        return this.departmentDaoService.departmentDetails();
    }

    @GetMapping(value = "/getFindDepartment/{departmentId}")
    public DepartmentDto getFindDepartment(@PathVariable Long departmentId) {
        return this.departmentDaoService.getByDepartment(departmentId);
    }

    @DeleteMapping(value = "/delete/{departmentId}")
    public void deleteCity(@PathVariable Long departmentId) {
        this.departmentDaoService.deleteDepartment(departmentId);
    }

}
