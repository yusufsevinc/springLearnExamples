package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.model.Company;

import java.util.List;

public interface CompanyDaoService {

    CompanyDto add(CompanyDto companyDto);
    List<Company> getAll();
    CompanyDto getByCompany(Long companyId);
    //List<Company> companyDetails();
    void deleteCompany(Long companyId);
}
