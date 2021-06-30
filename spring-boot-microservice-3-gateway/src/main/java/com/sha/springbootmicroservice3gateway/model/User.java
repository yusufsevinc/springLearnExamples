package com.sha.springbootmicroservice3gateway.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_username" , unique = true , nullable = false ,length = 100)
    private String userUserName;

    @Column(name = "user_password" , nullable = false)
    private String userPassword;

    @Column(name = "user_name" ,nullable = false)
    private String userName;

    @Column(name = "user_create_time" )
    private LocalDateTime userCreateTime;
}

