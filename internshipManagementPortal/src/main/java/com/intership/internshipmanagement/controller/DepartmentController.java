package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.DepartmentDto;
import com.intership.internshipmanagement.model.Department;
import com.intership.internshipmanagement.service.concretes.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private final DepartmentService departmentDaoService;

    public DepartmentController(DepartmentService departmentDaoService) {
        this.departmentDaoService = departmentDaoService;
    }

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
