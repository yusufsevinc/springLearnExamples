package com.intership.internshipmanagement.services.abstracts;

import com.intership.internshipmanagement.dtos.TeacherDto;
import com.intership.internshipmanagement.models.Teacher;

import java.util.List;

public interface TeacherDaoService {

    Teacher add(Teacher teacher);
    List<Teacher> getAll();
   // List<TeacherDto> getAllTeacherDto();
    //TeacherDto getByTeacherDto(Long teacherId);
    Teacher getByTeacher(Long teacherId);
    void deleteTeacher(Long teacherId);

}
