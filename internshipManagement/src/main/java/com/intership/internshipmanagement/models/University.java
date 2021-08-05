package com.intership.internshipmanagement.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intership.internshipmanagement.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.AbstractList;
import java.util.ArrayList;
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

    @Column(name = "degree")
    private Degree degree;



    @ManyToMany
    @JoinTable(name = "universities_teachers",
            joinColumns = {
                    @JoinColumn(name = "university_id", referencedColumnName = "university_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id",
                            nullable = false, updatable = false)})
    private List<Teacher> teachers ;


    @JsonIgnore
    @OneToMany(mappedBy = "universityStudent")
    private List<Student> universityStudents;




}
