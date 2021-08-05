package com.intership.internshipmanagement.dto;

import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherDto extends UserDto{

    private String firstName;
    private String lastName;
    private String phone;
    private String photoURL;
    private University universityUndergraduate;
    private UniversityDepartment universityDepartmentUndergraduate;
    private University universityGraduate;
    private UniversityDepartment universityDepartmentGraduate;
    private University universityDoctorate;
    private UniversityDepartment universityDepartmentDoctorate;

    //
    public TeacherDto(String email, String firstName, String lastName, String phone, String photoURL,
                      University universityUndergraduate, UniversityDepartment universityDepartmentUndergraduate,
                      University universityGraduate, UniversityDepartment universityDepartmentGraduate,
                      University universityDoctorate, UniversityDepartment universityDepartmentDoctorate) {

        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.photoURL = photoURL;
        this.universityUndergraduate = universityUndergraduate;
        this.universityDepartmentUndergraduate = universityDepartmentUndergraduate;
        this.universityGraduate = universityGraduate;
        this.universityDepartmentGraduate = universityDepartmentGraduate;
        this.universityDoctorate = universityDoctorate;
        this.universityDepartmentDoctorate = universityDepartmentDoctorate;
    }
}
