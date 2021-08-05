package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.service.concretes.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/university")
public class UniversityController {

    private  final UniversityService universityDaoService;

    public UniversityController(UniversityService universityDaoService) {
        this.universityDaoService = universityDaoService;
    }

    @PostMapping(value = "/addDto")
    public UniversityDto addDto(@RequestBody UniversityDto universityDto) {
        return this.universityDaoService.addDto(universityDto);

    }

    @PostMapping(value = "/add")
    public University add(@RequestBody University university) {
        return this.universityDaoService.add(university);
    }

/**/
    @GetMapping(value = "/getall")
    public String getall(Model model) {
    model.addAttribute("uni" , universityDaoService.getAll());
    return "universityViews/university";
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
    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{univresityId}")
    public String deleteUniversity(@PathVariable Long univresityId) {
        this.universityDaoService.deleteUniversity(univresityId);
        return "redirect:/university/getall";
    }
/**/
    @RequestMapping(value ="/admin/edit/{univresityId}")
    public ModelAndView editUniversityForm(@PathVariable Long univresityId) {
        ModelAndView modelAndView = new ModelAndView("universityViews/edit_university");
        University university = universityDaoService.getByUniversityId(univresityId);
        modelAndView.addObject("uni" , university);
        return modelAndView;
    }
/**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveUniversity(@ModelAttribute("uni") University university) {
        this.universityDaoService.add(university);
        return "redirect:/university/getall";
    }
/**/
    @RequestMapping("/admin/edit/newUniversity")
    public String newUniversityForm(Map<String, Object> model) {
        HashMap<String , Object> hashMap = new HashMap<>();
        University university = new University();
        UniversityDegree universityDegree = new UniversityDegree();
        hashMap.put("universityDegree" , universityDegree);
        hashMap.put("university" , university);
        model.putAll(hashMap);
        return "universityViews/new_university";
    }
}
