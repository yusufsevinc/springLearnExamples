package com.intership.internshipmanagement.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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


    @ManyToMany(mappedBy = "teachers")
    List<University> universities ;

    @ManyToMany(mappedBy = "teachers")
    List<UniversityDepartment> universityDepartments ;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Student> students;




}
