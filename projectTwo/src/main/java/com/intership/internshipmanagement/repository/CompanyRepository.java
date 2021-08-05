package com.intership.internshipmanagement.repository;

import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company , Long> {





}
