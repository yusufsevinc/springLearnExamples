package com.intership.internshipmanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "universities")
@NoArgsConstructor
@AllArgsConstructor
public class University  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_name" , nullable = false)
    private String universityName;

    @JsonIgnore
    @OneToMany(mappedBy = "universityUndergraduate")
    private List<Teacher> teachersUniversityUndergraduate;

    @JsonIgnore
    @OneToMany(mappedBy = "universityGraduate")
    private List<Teacher> teachersUniversityGraduate;

    @JsonIgnore
    @OneToMany(mappedBy = "universityDoctorate")
    private List<Teacher> teachersUniversityDoctorate;

    @JsonIgnore
    @OneToMany(mappedBy = "universityStudent")
    private List<Student> universityStudents;

    //private String degree;




}
