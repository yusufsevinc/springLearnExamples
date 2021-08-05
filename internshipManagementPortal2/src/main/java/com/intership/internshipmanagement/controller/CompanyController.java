package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.repository.CompanyRepository;
import com.intership.internshipmanagement.service.abstracts.CityDaoService;
import com.intership.internshipmanagement.service.abstracts.CompanyDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private  CompanyDaoService companyDaoService;

    @GetMapping(value = "/getall")
    public List<Company> getall() {
        return this.companyDaoService.getAll();
    }

    @GetMapping(value = "/getfindcompany/{companyId}")
    public CompanyDto getByCompany(@PathVariable Long companyId) {
        return this.companyDaoService.getByCompany(companyId);
    }

    @PostMapping(value = "/add")
    public CompanyDto add(@RequestBody CompanyDto companyDto) {
        return this.companyDaoService.add(companyDto);

    }

    @DeleteMapping(value = "/delete/{companyId}")
    public void deleteCompany(@PathVariable Long companyId) {
        this.companyDaoService.deleteCompany(companyId);
    }
}
