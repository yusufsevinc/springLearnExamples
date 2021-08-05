package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.DepartmentDto;
import com.intership.internshipmanagement.model.Department;
import com.intership.internshipmanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService  {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    


    public DepartmentDto add(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        return modelMapper.map(departmentRepository.save(department), DepartmentDto.class);
    }


    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }


    public DepartmentDto getByDepartment(Long departmentId) {

        return modelMapper.map(this.departmentRepository.findById(departmentId)
        .orElseThrow(() -> new NotFoundException(Message.errorDepartmentGetById))
        ,DepartmentDto.class);
    }

    public Department getFindDepartment(Long departmentId) {
        return this.departmentRepository.findById(departmentId)
                        .orElseThrow(() -> new NotFoundException(Message.errorDepartmentGetById));
    }


    public List<DepartmentDto> departmentDetails() {

        return this.departmentRepository.departmentDetails();
    }


    public void deleteDepartment(Long departmentId) {
        boolean isExist = this.departmentRepository.existsById(departmentId);

        if (isExist){
            this.departmentRepository.deleteById(departmentId);
        }else
            throw new InternalServerError(Message.errorDepartmentGetById);

    }


}
