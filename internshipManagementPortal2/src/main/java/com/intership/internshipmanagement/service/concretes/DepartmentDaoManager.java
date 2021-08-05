package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.dto.DepartmentDto;
import com.intership.internshipmanagement.model.Company;
import com.intership.internshipmanagement.model.Department;
import com.intership.internshipmanagement.repository.CompanyRepository;
import com.intership.internshipmanagement.repository.DepartmentRepository;
import com.intership.internshipmanagement.service.abstracts.CityDaoService;
import com.intership.internshipmanagement.service.abstracts.DepartmentDaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentDaoManager implements DepartmentDaoService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto add(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        return modelMapper.map(departmentRepository.save(department), DepartmentDto.class);
    }

    @Override
    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public DepartmentDto getByDepartment(Long departmentId) {
        Department department = modelMapper.map(departmentId , Department.class);

        return modelMapper.map(this.departmentRepository.findById(departmentId)
        .orElseThrow(() -> new NotFoundException(Message.errorDepartmentGetById))
        ,DepartmentDto.class);
    }


    @Override
    public List<DepartmentDto> departmentDetails() {

        return this.departmentRepository.departmentDetails();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        boolean isExist = this.departmentRepository.existsById(departmentId);

        if (isExist){
            this.departmentRepository.deleteById(departmentId);
        }else
            throw new InternalServerError(Message.errorDepartmentGetById);

    }


}
