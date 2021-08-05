package com.intership.internshipmanagement.controllers;

import com.intership.internshipmanagement.dtos.TeacherDto;
import com.intership.internshipmanagement.models.Teacher;
import com.intership.internshipmanagement.services.abstracts.TeacherDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherDaoService teacherDaoService;


    @GetMapping(value = "/getall")
    public List<Teacher> getall() {
        return this.teacherDaoService.getAll();
    }
/*
    @GetMapping(value = "/getAllTeacherDto")
    public List<TeacherDto> getAllTeacherDto() {
        return this.teacherDaoService.getAllTeacherDto();
    }
    @GetMapping(value = "/getFindTeacherDto/{teacherId}")
    public TeacherDto getByTeacherDto(@PathVariable Long teacherId) {
        return this.teacherDaoService.getByTeacherDto(teacherId);
    }*/
    @PostMapping(value = "/add")
    public Teacher add(@RequestBody Teacher teacher){
        return this.teacherDaoService.add(teacher);
    }


    @GetMapping(value = "/getFindTeacher/{teacherId}")
    public Teacher getByTeacher(@PathVariable Long teacherId) {
        return this.teacherDaoService.getByTeacher(teacherId);
    }





    @DeleteMapping(value = "/delete/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        this.teacherDaoService.deleteTeacher(teacherId);
    }
}
