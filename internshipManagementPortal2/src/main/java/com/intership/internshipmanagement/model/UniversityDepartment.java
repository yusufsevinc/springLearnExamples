package com.intership.internshipmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "university_departments")
@AllArgsConstructor
@NoArgsConstructor

public class UniversityDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_department_id")
    private Long universityDepartmentId;

    @Column(name = "university_department_name" , nullable = false)
    private String universityDepartmentName;

    @JsonIgnore
    @OneToMany(mappedBy = "universityDepartmentUndergraduate")
    private List<Teacher> teachersUniversityDepartmentUndergraduate;

    @JsonIgnore
    @OneToMany(mappedBy = "universityDepartmentGraduate")
    private List<Teacher> teachersUniversityDepartmentGraduate;

    @JsonIgnore
    @OneToMany(mappedBy = "universityDepartmentDoctorate")
    private List<Teacher> teachersUniversityDepartmentDoctorate;

    @JsonIgnore
    @OneToMany(mappedBy = "universityDepartmentStudent")
    private List<Student> universityDepartmentStudents;



}
