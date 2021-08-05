package com.intership.internshipmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany
    @JoinTable(name = "universityDepartments_teachers",
            joinColumns = {
                    @JoinColumn(name = "university_department_id", referencedColumnName = "university_department_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id",
                            nullable = false, updatable = false)})
    private List<Teacher> teachers ;



    @JsonIgnore
    @OneToMany(mappedBy = "universityDepartmentStudent")
    private List<Student> universityDepartmentStudents;



}
