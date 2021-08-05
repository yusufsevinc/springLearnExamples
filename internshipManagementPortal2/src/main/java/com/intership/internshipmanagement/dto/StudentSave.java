package com.intership.internshipmanagement.dto;

import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentSave extends UserDto{

    private String firstName;
    private String lastName;
    private String studentNo;
    private String phone;
    private String classNo;
    private String photoURL;
    private Company company;
    private Long department;
    private Long teacher;
    private Long universityStudent;
    private Long universityDepartmentStudent;







}
