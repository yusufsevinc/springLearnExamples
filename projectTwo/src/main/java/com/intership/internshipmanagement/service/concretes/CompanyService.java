package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.dto.CompanySaveDto;
import com.intership.internshipmanagement.dto.converter.CompanyDtoConverter;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    private final CompanyDtoConverter companyDtoConverter;
    private final CityDaoService cityDaoManager;


    public Company add(Company company) {

        return this.companyRepository.save(company);



    }


    public Company add(CompanySaveDto company) {
            City city = this.cityDaoManager.findByCity(company.getCityId());
            Company company1 = new Company();
            company1.setCity(city);
            company1.setAddress(company.getAddress());
            company1.setWebAddress(company.getWebAddress());
            company1.setName(company.getName());
            company1.setPassword(company.getPassword());
            company1.setEmail(company.getEmail());

        return this.companyRepository.save(company1);
    }


    public List<Company> getAll() {
        return this.companyRepository.findAll();
    }


    public CompanyDto getByCompany(Long companyId) {
        return modelMapper.map(companyRepository.findById(companyId).orElseThrow(
                () -> new NotFoundException(Message.errorCompanyGetById))
                , CompanyDto.class);
    }

    public Company getFindCompany(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(
                () -> new NotFoundException(Message.errorCompanyGetById));
    }


    public List<CompanyDto> companyDetails() {
        return  companyRepository
                .findAll()
                .stream()
                .map(companyDtoConverter::convert)
                .collect(Collectors.toList());
    }




    public void deleteCompany(Long companyId) {
        boolean isExist = this.companyRepository.existsById(companyId);

        if (isExist) {
            this.companyRepository.deleteById(companyId);
        } else {
            throw new InternalServerError(Message.errorCompanyGetById);
        }
    }
}
