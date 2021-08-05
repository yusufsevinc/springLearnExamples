package com.intership.internshipmanagement.repository;

import com.intership.internshipmanagement.dto.StudentSave;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.Student;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {




}
