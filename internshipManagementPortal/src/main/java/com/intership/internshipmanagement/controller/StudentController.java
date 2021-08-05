package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.StudentDto;
import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.model.Student;
import com.intership.internshipmanagement.service.concretes.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentDaoManager;

    public StudentController(StudentService studentDaoManager) {
        this.studentDaoManager = studentDaoManager;
    }

    @PostMapping(value = "/add")
    public Student add(@RequestBody StudentSaveDto student){
        return this.studentDaoManager.add(student);
    }

    @GetMapping(value = "/getAll")
    public List<Student> getAll(){

        return this.studentDaoManager.getAll();
    }

    @GetMapping(value = "/getAllDto")
    public List<StudentDto> getAllDto(){

        return this.studentDaoManager.getAllDto();
    }

    @GetMapping(value = "/getByStudent/{studentId}")
    public Student getByStudent(@PathVariable Long studentId){
        return this.studentDaoManager.getByStudent(studentId);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
         this.studentDaoManager.deleteStudent(studentId);
    }






}
