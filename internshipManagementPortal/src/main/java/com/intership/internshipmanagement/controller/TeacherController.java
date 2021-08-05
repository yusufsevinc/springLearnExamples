package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.model.Teacher;
import com.intership.internshipmanagement.service.concretes.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {


    private final TeacherService teacherDaoService;

    public TeacherController(TeacherService teacherDaoService) {
        this.teacherDaoService = teacherDaoService;
    }

    @GetMapping(value = "/getall")
    public List<Teacher> getall() {
        return this.teacherDaoService.getAll();
    }

    @GetMapping(value = "/getAllTDto")
    public List<TeacherDto> getAllTeacherDto() {
        return this.teacherDaoService.getAllDto();
    }
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
