package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.model.Teacher;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.service.concretes.TeacherService;
import com.intership.internshipmanagement.service.concretes.UniversityDegreeService;
import com.intership.internshipmanagement.service.concretes.UniversityDepartmentService;
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
@RequestMapping(value = "/teacher")
public class TeacherController {


    private final TeacherService teacherDaoService;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;

    public TeacherController(TeacherService teacherDaoService,
                             UniversityService universityService,
                             UniversityDepartmentService universityDepartmentService,
                             UniversityDegreeService universityDegreeService) {
        this.teacherDaoService = teacherDaoService;
        this.universityService = universityService;
        this.universityDepartmentService = universityDepartmentService;
        this.universityDegreeService = universityDegreeService;
    }



    @GetMapping(value = "/getall")
    public String getall(Model model) {
        model.addAttribute("teacher", teacherDaoService.getAll());
        return "teacherViews/teacher";
    }

    @GetMapping(value = "/getAllTDto")
    public List<TeacherDto> getAllTeacherDto() {
        return this.teacherDaoService.getAllDto();
    }

    @PostMapping(value = "/add")
    public Teacher add(@RequestBody Teacher teacher) {
        return this.teacherDaoService.add(teacher);
    }
    @PostMapping(value = "/addDto")
    public Teacher addDto(@RequestBody TeacherSaveDto teacherSaveDto) {
        return this.teacherDaoService.addDto(teacherSaveDto);
    }


    @GetMapping(value = "/getFindTeacher/{teacherId}")
    public Teacher getByTeacher(@PathVariable Long teacherId) {
        return this.teacherDaoService.getByTeacher(teacherId);
    }

/*
    @DeleteMapping(value = "/delete/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        this.teacherDaoService.deleteTeacher(teacherId);
    }
*/

    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{teacherId}")
    public String deleteTeacher(@PathVariable Long teacherId) {
        this.teacherDaoService.deleteTeacher(teacherId);
        return "redirect:/teacher/getall";
    }

    @RequestMapping(value ="/admin/edit/{teacherId}")
    public ModelAndView editTeacherForm(@PathVariable Long teacherId) {
        ModelAndView modelAndView = new ModelAndView("teacherViews/edit_teacher");
        Teacher teacher = teacherDaoService.getByTeacher(teacherId);
        modelAndView.addObject("teacher" , teacher);
        return modelAndView;
    }

    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("uni") TeacherSaveDto teacher) {
        this.teacherDaoService.addDto(teacher);
        return "redirect:/teacher/getall";
    }
    /**/

    @RequestMapping("/admin/edit/newTeacher")
    public String newTeacherForm(Map<String, Object> model) {
        TeacherSaveDto teacher = new TeacherSaveDto();
        List<University> universities = this.universityService.getAll();
        List<UniversityDepartment> universityDepartments = this.universityDepartmentService.getAll();
        List<UniversityDegree> universityDegrees = this.universityDegreeService.getAll();
        HashMap<String , Object> hashMap = new HashMap<>();
        hashMap.put("teacher" , teacher);
        hashMap.put("university" , universities);
        hashMap.put("universityDepartment" , universityDepartments);
        hashMap.put("universityDegree" , universityDegrees);
        model.putAll(hashMap);
        return "teacherViews/new_teacher";
    }
}