package com.spring.learn.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private int id;
	
	@Column(name = "person_name" , nullable = false , length = 40)
	private String personName;
	
	@Column(name = "person_surname" , nullable = false , length = 40)
	private String personSurame;
	
	@Column(name = "person_birthYear" , nullable = false)
	private int personBirthYear;
	
	
}
