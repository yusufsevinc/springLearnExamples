package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.service.concretes.UniversityService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class UniversityController {


    private  final UniversityService universityDaoService;

    public UniversityController(UniversityService universityDaoService) {
        this.universityDaoService = universityDaoService;
    }


    @PostMapping(value = "/add")
    public UniversityDto add(@RequestBody UniversityDto universityDto) {
        return this.universityDaoService.add(universityDto);

    }
/*
    @GetMapping(value = "/getall")
    public List<University> getall() {
        return this.universityDaoService.getAll();
    }
*/

@GetMapping(value = "/getall")
public String getall(Model model) {
    model.addAttribute("uni" , universityDaoService.getAll());

    return "home" ;
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
