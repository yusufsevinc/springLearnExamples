package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.repository.CompanyRepository;
import com.intership.internshipmanagement.service.abstracts.CompanyDaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyDaoManager implements CompanyDaoService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    public CompanyDto add(CompanyDto companyDto) {
        Company company = modelMapper.map(companyDto, Company.class);
        return modelMapper.map(companyRepository.save(company), CompanyDto.class);

    }

    @Override
    public List<Company> getAll() {
        return this.companyRepository.findAll();
    }

    @Override
    public CompanyDto getByCompany(Long companyId) {
        return modelMapper.map(companyRepository.findById(companyId).orElseThrow(
                () -> new NotFoundException(Message.errorCompanyGetById))
                , CompanyDto.class);
    }


    @Override
    public void deleteCompany(Long companyId) {
        boolean isExist = this.companyRepository.existsById(companyId);

        if (isExist) {
            this.companyRepository.deleteById(companyId);
        } else {
            throw new InternalServerError(Message.errorCompanyGetById);
        }
    }
}
