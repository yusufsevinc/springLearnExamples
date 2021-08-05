package com.intership.internshipmanagement.controllers;

import com.intership.internshipmanagement.dtos.UniversityDto;
import com.intership.internshipmanagement.models.University;
import com.intership.internshipmanagement.services.abstracts.UniversityDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class UniversityController {

    @Autowired
    private UniversityDaoService universityDaoService;

    @PostMapping(value = "/add")
    public UniversityDto add(@RequestBody UniversityDto universityDto) {
        return this.universityDaoService.add(universityDto);

    }

    @GetMapping(value = "/getall")
    public List<University> getall() {
        return this.universityDaoService.getAll();
    }

    @GetMapping(value = "/getallDto")
    public List<UniversityDto> getallDto() {
        return this.universityDaoService.getAllDto();
    }

    @GetMapping(value = "/getFindUniversityDto/{getByUniversityDtoId}")
    public UniversityDto getByUniversityDto(@PathVariable Long getByUniversityDtoId) {
        return this.universityDaoService.getByUniversityDtoId(getByUniversityDtoId);
    }

    @GetMapping(value = "/getFindUniversity/{univresityId}")
    public University getByUniversityId(@PathVariable Long univresityId) {
        return this.universityDaoService.getByUniversityId(univresityId);
    }

    @DeleteMapping(value = "/delete/{univresityId}")
    public void deleteCity(@PathVariable Long univresityId) {
        this.universityDaoService.deleteUniversity(univresityId);
    }



}
