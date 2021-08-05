package com.intership.internshipmanagement.repository;

import com.intership.internshipmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Company , Long> {


}
