package com.intership.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String username;
    private String password;
    private boolean disabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private String role;








}
