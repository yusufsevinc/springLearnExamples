package com.spring.project.hibernateAndJpa.dataAcces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.project.hibernateAndJpa.entitiy.User;

public interface UserDao  extends JpaRepository<User, Integer>{
	

}
