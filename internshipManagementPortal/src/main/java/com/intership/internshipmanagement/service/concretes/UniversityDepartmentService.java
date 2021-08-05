package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.UniversityDepartmentDto;
import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.repository.UniversityDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityDepartmentService  {

    private final UniversityDepartmentRepository universityDepartmentRepository;
    private final ModelMapper modelMapper;


    public UniversityDepartmentDto add(UniversityDepartmentDto universityDepartmentDto) {
        UniversityDepartment universityDepartment = modelMapper.map(universityDepartmentDto,UniversityDepartment.class);
        return modelMapper.map(this.universityDepartmentRepository.save(universityDepartment)
        ,UniversityDepartmentDto.class);
    }


    public List<UniversityDepartment> getAll() {
        return this.universityDepartmentRepository.findAll();
    }


    public List<UniversityDepartmentDto> getAllDto() {
        return this.universityDepartmentRepository.getAllDto();
    }


    public UniversityDepartment getByUniversityDepartmentId(Long universityDepartmentId) {
        boolean isExist = this.universityDepartmentRepository.existsById(universityDepartmentId);
        if (isExist) {
            return this.universityDepartmentRepository.getByUniversityDepartmentId(universityDepartmentId);
        } else{
            throw new InternalServerError(Message.errorUniversityDepartmentGetById);
        }
    }


    public void deleteUniversityDepartment(Long universityDepartmentId) {
        boolean isExist = this.universityDepartmentRepository.existsById(universityDepartmentId);

        if (isExist) {
            this.universityDepartmentRepository.deleteById(universityDepartmentId);
        } else{
            throw new InternalServerError(Message.errorUniversityDepartmentGetById);
        }
    }


    public UniversityDepartmentDto getByUniversityDepartmentDtoId(Long universityDepartmentId) {
        return modelMapper.map(universityDepartmentRepository.findById(universityDepartmentId).orElseThrow(
                () -> new NotFoundException(Message.errorUniversityDepartmentGetById))
                , UniversityDepartmentDto.class);
    }
}
