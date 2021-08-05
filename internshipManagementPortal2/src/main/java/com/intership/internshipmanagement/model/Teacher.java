package com.intership.internshipmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "teacher_id" , referencedColumnName = "id")

public class Teacher extends User   {

    @Column(name = "first_name" , nullable = false ,length = 70)
    private String firstName;
    @Column(name = "last_name" , nullable = false ,length = 70)
    private String lastName;
    @Column(name = "phone" , nullable = false ,length = 70 , unique = true)
    private String phone;
    @Column(name = "photo_URL" , nullable = false ,length = 70)
    private String photoURL;

    @ManyToOne
    @JoinColumn(name = "undergraduate_study_id")
    private University universityUndergraduate;

    @ManyToOne
    @JoinColumn(name = "graduate_study_id")
    private University universityGraduate;

    @ManyToOne
    @JoinColumn(name = "doctorate_study_id")
    private University universityDoctorate;

    @ManyToOne
    @JoinColumn(name = "undergraduate_study_department_id")
    private UniversityDepartment universityDepartmentUndergraduate;

    @ManyToOne
    @JoinColumn(name = "graduate_study_department_id")
    private UniversityDepartment universityDepartmentGraduate;

    @ManyToOne
    @JoinColumn(name = "doctorate_study_department_id")
    private UniversityDepartment universityDepartmentDoctorate;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Student> students;




}
