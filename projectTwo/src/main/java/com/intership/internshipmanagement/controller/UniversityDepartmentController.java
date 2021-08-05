package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.UniversityDepartmentDto;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.service.concretes.UniversityDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/universityDepartment")
public class UniversityDepartmentController {


    private final UniversityDepartmentService universityDepartmentDaoService;

    public UniversityDepartmentController(UniversityDepartmentService universityDepartmentDaoService) {
        this.universityDepartmentDaoService = universityDepartmentDaoService;
    }

    @PostMapping(value = "/add")
    public UniversityDepartmentDto add(@RequestBody UniversityDepartmentDto universityDepartmentDto) {
        return this.universityDepartmentDaoService.addDto(universityDepartmentDto);

    }
/**/
    @GetMapping(value = "/getall")
    public String getall(Model model) {
        model.addAttribute("universityDepartment" , universityDepartmentDaoService.getAll());
        return "universityDepartmentsViews/university_department";

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
/**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{universityDepartmentId}")
    public String deleteCity(@PathVariable Long universityDepartmentId) {
        this.universityDepartmentDaoService.deleteUniversityDepartment(universityDepartmentId);
        return "redirect:/universityDepartment/getall";

    }
    /**/
    @RequestMapping(value ="/admin/edit/{universityDepartmentId}")
    public ModelAndView editUniversityForm(@PathVariable Long universityDepartmentId) {
        ModelAndView modelAndView = new ModelAndView("universityDepartmentsViews/edit_university_department");
        UniversityDepartment universityDepartment = universityDepartmentDaoService.getByUniversityDepartmentId(universityDepartmentId);
        modelAndView.addObject("uniDepartment" , universityDepartment);
        return modelAndView;
    }
    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveUniversityDepartment(@ModelAttribute("uni") UniversityDepartment universityDepartment) {
        this.universityDepartmentDaoService.add(universityDepartment);
        return "redirect:/universityDepartment/getall";
    }
/**/
    @RequestMapping("/admin/edit/newUniversityDepartment")
    public String newUniversityForm(Map<String, Object> model) {
        UniversityDepartment universityDepartment = new UniversityDepartment();
        model.put("uniDepartment", universityDepartment);
        return "universityDepartmentsViews/new_university_department";
    }
}
