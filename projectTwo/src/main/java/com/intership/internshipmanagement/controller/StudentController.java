package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.dto.StudentDto;
import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.service.concretes.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentDaoManager;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;
    private final TeacherService teacherService;
    private final CompanyService companyService;
    private final DepartmentService departmentService;


    public StudentController(StudentService studentDaoManager,
                             UniversityService universityService,
                             UniversityDepartmentService universityDepartmentService,
                             UniversityDegreeService universityDegreeService,
                             TeacherService teacherService, CompanyService companyService,
                             DepartmentService departmentService) {
        this.studentDaoManager = studentDaoManager;
        this.universityService = universityService;
        this.universityDepartmentService = universityDepartmentService;
        this.universityDegreeService = universityDegreeService;
        this.teacherService = teacherService;
        this.companyService = companyService;
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/add")
    public Student add(@RequestBody StudentSaveDto student){
        return this.studentDaoManager.add(student);
    }

    @GetMapping(value = "/getall")
    public String getAll(Model model){
        try {
            model.addAttribute("student" ,  this.studentDaoManager.getAll());
            return "studentViews/student";
        }catch (Exception e){
             throw new NotFoundException("e.getMessage()");
        }


    }

    @GetMapping(value = "/getalla")
    public List<Student> getAlla(){
        return   this.studentDaoManager.getAll();

    }

    @GetMapping(value = "/getAllDto")
    public List<StudentDto> getAllDto(){

        return this.studentDaoManager.getAllDto();
    }

    @GetMapping(value = "/getByStudent/{studentId}")
    public Student getByStudent(@PathVariable Long studentId){
        return this.studentDaoManager.getByStudent(studentId);
    }

   /* @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
         this.studentDaoManager.deleteStudent(studentId);
    }*/

    /**/
    @Transactional
    @RequestMapping(value = "/admin/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        this.studentDaoManager.deleteStudent(studentId);
        return "redirect:/student/getall";
    }

    @RequestMapping(value ="/admin/edit/{studentId}")
    public ModelAndView editStudentForm(@PathVariable Long studentId) {
        ModelAndView modelAndView = new ModelAndView("studentViews/edit_student");
        Student student = studentDaoManager.getByStudent(studentId);
        modelAndView.addObject("student" , student);
        return modelAndView;
    }

    /**/
    @Transactional
    @RequestMapping(value = "/admin/edit/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("uni") StudentSaveDto student) {
        this.studentDaoManager.add(student);
        return "redirect:/student/getall";
    }
    /**/

    @RequestMapping("/admin/edit/newStudent")
    public String newstudentForm(Map<String, Object> model) {
        StudentSaveDto student = new StudentSaveDto();
        List<University> universities = this.universityService.getAll();
        List<UniversityDepartment> universityDepartments = this.universityDepartmentService.getAll();
        List<UniversityDegree> universityDegrees = this.universityDegreeService.getAll();
        List<Teacher> teachers = this.teacherService.getAll();
        List<Company> companies = this.companyService.getAll();
        List<Department> departments = this.departmentService.getAll();

        HashMap<String , Object> hashMap = new HashMap<>();
        hashMap.put("student" , student);
        hashMap.put("university" , universities);
        hashMap.put("universityDepartment" , universityDepartments);
        hashMap.put("universityDegree" , universityDegrees);
        hashMap.put("teacher" , teachers);
        hashMap.put("company" , companies);
        hashMap.put("department" , departments);
        model.putAll(hashMap);
        return "studentViews/new_student";
    }




}
