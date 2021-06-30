package com.spring.project.hibernateAndJpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.hibernateAndJpa.dataAcces.UserDao;
import com.spring.project.hibernateAndJpa.entitiy.User;

@RestController

public class Api {
	private UserDao dao;
	
	
	@Autowired
	public Api(UserDao dao) {
		super();
		this.dao = dao;
	}



	@GetMapping("/add")
	public String mesaj() {
	User user = new User();
	user.setUserName("asd3");
	
	dao.save(user);
		return "mesajja";
	}
}
