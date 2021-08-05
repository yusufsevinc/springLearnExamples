package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.model.Student;

import java.util.List;

public interface StudentDaoService {
    Student add(Student student);
    List<Student> getAll();
    Student getByStudent(Long studentId);
    void deleteStudent(Long studentId);



}
