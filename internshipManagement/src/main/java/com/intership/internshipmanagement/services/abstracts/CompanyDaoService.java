package com.intership.internshipmanagement.services.abstracts;

import com.intership.internshipmanagement.dtos.CompanyDto;
import com.intership.internshipmanagement.models.Company;

import java.util.List;

public interface CompanyDaoService {

    CompanyDto add(CompanyDto companyDto);
    List<Company> getAll();
    CompanyDto getByCompany(Long companyId);
    //List<Company> companyDetails();
    void deleteCompany(Long companyId);
}
