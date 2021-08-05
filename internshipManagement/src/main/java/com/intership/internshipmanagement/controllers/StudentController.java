package com.intership.internshipmanagement.controllers;

import com.intership.internshipmanagement.models.Student;
import com.intership.internshipmanagement.services.concretes.StudentDaoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDaoManager studentDaoManager;

    @PostMapping(value = "/add")
    public Student add(@RequestBody Student student){
        return this.studentDaoManager.add(student);
    }

    @GetMapping(value = "/getAll")
    public List<Student> getAll(){
        return this.studentDaoManager.getAll();
    }

    @GetMapping(value = "/getByStudent/{studentId}")
    public Student getByStudent(@PathVariable Long studentId){
        return this.studentDaoManager.getByStudent(studentId);
    }

    @GetMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
         this.studentDaoManager.deleteStudent(studentId);
    }





}
