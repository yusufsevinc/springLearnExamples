package com.intership.internshipmanagement.model;


import com.intership.internshipmanagement.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(name = "degree" , nullable = false)
    private Degree degree;


    @ManyToMany(mappedBy = "universities", cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;


    @OneToMany(mappedBy = "universityStudent")
    private List<Student> universityStudents;




}
