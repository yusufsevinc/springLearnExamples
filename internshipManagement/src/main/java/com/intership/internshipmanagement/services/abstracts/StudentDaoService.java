package com.intership.internshipmanagement.services.abstracts;

import com.intership.internshipmanagement.models.Student;

import java.util.List;

public interface StudentDaoService {
    Student add(Student student);
    List<Student> getAll();
    Student getByStudent(Long studentId);
    void deleteStudent(Long studentId);



}
