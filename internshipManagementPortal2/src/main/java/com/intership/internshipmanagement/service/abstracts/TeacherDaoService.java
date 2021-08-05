package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.model.Teacher;

import java.util.List;

public interface TeacherDaoService {

    Teacher add(Teacher teacher);
    List<Teacher> getAll();
    List<TeacherDto> getAllTeacherDto();
    TeacherDto getByTeacherDto(Long teacherId);
    Teacher getByTeacher(Long teacherId);
    void deleteTeacher(Long teacherId);

}
