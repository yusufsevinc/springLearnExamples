package com.intership.internshipmanagement.repositorys;

import com.intership.internshipmanagement.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Company , Long> {


}
