package com.intership.internshipmanagement.controllers;

import com.intership.internshipmanagement.dtos.UniversityDepartmentDto;
import com.intership.internshipmanagement.models.UniversityDepartment;
import com.intership.internshipmanagement.services.abstracts.UniversityDepartmentDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/univresityDepartment")
public class UniversityDepartmentController {

    @Autowired
    private UniversityDepartmentDaoService universityDepartmentDaoService;

    @PostMapping(value = "/add")
    public UniversityDepartmentDto add(@RequestBody UniversityDepartmentDto universityDepartmentDto) {
        return this.universityDepartmentDaoService.add(universityDepartmentDto);

    }

    @GetMapping(value = "/getall")
    public List<UniversityDepartment> getall() {
        return this.universityDepartmentDaoService.getAll();
    }

    @GetMapping(value = "/getallDto")
    public List<UniversityDepartmentDto> getallDto() {
        return this.universityDepartmentDaoService.getAllDto();
    }

    @GetMapping(value = "/getFindUniversityDepartmentDto/{universityDepartmentDtoId}")
    public UniversityDepartmentDto getByUniversityDepartmentDto(@PathVariable Long universityDepartmentDtoId) {
        return this.universityDepartmentDaoService.getByUniversityDepartmentDtoId(universityDepartmentDtoId);
    }

    @GetMapping(value = "/getFindUniversityDepartment/{universityDepartmentId}")
    public UniversityDepartment getByUniversityDepartmentId(@PathVariable Long universityDepartmentId) {
        return this.universityDepartmentDaoService.getByUniversityDepartmentId(universityDepartmentId);
    }

    @DeleteMapping(value = "/delete/{univresityDepartmentId}")
    public void deleteCity(@PathVariable Long univresityDepartmentId) {
        this.universityDepartmentDaoService.deleteUniversityDepartment(univresityDepartmentId);
    }
}
