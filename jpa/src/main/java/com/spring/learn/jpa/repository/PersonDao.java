package com.spring.learn.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.learn.jpa.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{

}
