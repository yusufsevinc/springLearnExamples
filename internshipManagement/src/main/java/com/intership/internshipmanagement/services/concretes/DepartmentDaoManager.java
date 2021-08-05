package com.intership.internshipmanagement.services.concretes;

import com.intership.internshipmanagement.cores.exception.InternalServerError;
import com.intership.internshipmanagement.cores.exception.NotFoundException;
import com.intership.internshipmanagement.cores.message.Message;
import com.intership.internshipmanagement.dtos.DepartmentDto;
import com.intership.internshipmanagement.models.Department;
import com.intership.internshipmanagement.repositorys.DepartmentRepository;
import com.intership.internshipmanagement.services.abstracts.DepartmentDaoService;
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
