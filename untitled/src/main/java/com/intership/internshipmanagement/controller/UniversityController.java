package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.facade.concretes.UniversityFacadeImpl;
import com.intership.internshipmanagement.model.University;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/university")
public class UniversityController {

    private  final UniversityFacadeImpl UniversityFacade;

    public UniversityController(UniversityFacadeImpl universityFacade) {
        UniversityFacade = universityFacade;
    }


    /**/
    @GetMapping(value = "/getall")
    public String getall(Model model) {
    model.addAttribute("uni" , UniversityFacade.getAll());
    return "universityViews/university";
}



    @GetMapping(value = "/getFindUniversity/{univresityId}")
    public University getByUniversityId(@PathVariable Long univresityId) {
        return this.UniversityFacade.getByUniversityId(univresityId);
    }
    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{univresityId}")
    public String deleteUniversity(@PathVariable Long univresityId) {
        this.UniversityFacade.deleteUniversity(univresityId);
        return "redirect:/university/getall";
    }
/**/
    @RequestMapping(value ="/admin/edit/{univresityId}")
    public ModelAndView editUniversityForm(@PathVariable Long univresityId) {
        ModelAndView modelAndView = new ModelAndView("universityViews/edit_university");
        University university = UniversityFacade.getByUniversityId(univresityId);
        modelAndView.addObject("uni" , university);
        return modelAndView;
    }
/**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveUniversity(@ModelAttribute("uni") University university) {
        this.UniversityFacade.add(university);
        return "redirect:/university/getall";
    }
/**/
    @RequestMapping("/admin/edit/newUniversity")
    public String newUniversityForm(Map<String, Object> model) {
        HashMap<String , Object> hashMap = new HashMap<>();
        University university = new University();

        hashMap.put("university" , university);
        model.putAll(hashMap);
        return "universityViews/new_university";
    }
}
