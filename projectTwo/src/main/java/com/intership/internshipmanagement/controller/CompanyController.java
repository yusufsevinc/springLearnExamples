package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.service.concretes.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {


    private final CompanyService companyDaoService;

    public CompanyController(CompanyService companyDaoService) {
        this.companyDaoService = companyDaoService;
    }

    @GetMapping(value = "/getall")
    public List<Company> getall() {
        return this.companyDaoService.getAll();
    }

    @GetMapping(value = "/getallDto")
    public List<CompanyDto> getallDto() {
        return this.companyDaoService.companyDetails();
    }

    @GetMapping(value = "/getfindcompany/{companyId}")
    public CompanyDto getByCompany(@PathVariable Long companyId) {
        return this.companyDaoService.getByCompany(companyId);
    }

    @PostMapping(value = "/add")
    public Company add(@RequestBody Company company) {
        return this.companyDaoService.add(company);

    }

    @PostMapping(value = "/addDto")
    public Company adddTO(@RequestBody CompanySaveDto company) {
        return this.companyDaoService.add(company);

    }

    @DeleteMapping(value = "/delete/{companyId}")
    public void deleteCompany(@PathVariable Long companyId) {
        this.companyDaoService.deleteCompany(companyId);
    }


}
