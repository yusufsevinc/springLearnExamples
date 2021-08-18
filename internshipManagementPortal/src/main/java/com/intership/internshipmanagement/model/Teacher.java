package com.intership.internshipmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "teacher_id" , referencedColumnName = "id")

public class Teacher extends User {

    @Column(name = "first_name" , nullable = false ,length = 70)
    private String firstName;
    @Column(name = "last_name" , nullable = false ,length = 70)
    private String lastName;
    @Column(name = "phone" , nullable = false ,length = 70 , unique = true)
    private String phone;
    @Column(name = "photo_URL" , nullable = false ,length = 70)
    private String photoURL;


    @ManyToMany(targetEntity = University.class, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "teachers_universities", joinColumns = { @JoinColumn(name = "teacher_id" , updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "university_id" , updatable = false) })
    private List<University> universities;



    @ManyToMany(targetEntity = UniversityDepartment.class, cascade = {CascadeType.PERSIST})
    @JoinTable(name = "teachers_universityDeparments", joinColumns = { @JoinColumn(name = "teacher_id") },
            inverseJoinColumns = { @JoinColumn(name = "university_department_id") })
    private List<UniversityDepartment> universityDepartments ;


    @OneToMany(mappedBy = "teacher")
    private List<Student> students;




}
