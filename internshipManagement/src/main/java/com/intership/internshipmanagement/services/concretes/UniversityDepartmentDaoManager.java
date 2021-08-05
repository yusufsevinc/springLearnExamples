package com.intership.internshipmanagement.services.concretes;

import com.intership.internshipmanagement.cores.exception.InternalServerError;
import com.intership.internshipmanagement.cores.exception.NotFoundException;
import com.intership.internshipmanagement.cores.message.Message;
import com.intership.internshipmanagement.dtos.UniversityDepartmentDto;
import com.intership.internshipmanagement.models.UniversityDepartment;
import com.intership.internshipmanagement.repositorys.UniversityDepartmentRepository;
import com.intership.internshipmanagement.services.abstracts.UniversityDepartmentDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityDepartmentDaoManager implements UniversityDepartmentDaoService {

    private final UniversityDepartmentRepository universityDepartmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public UniversityDepartmentDto add(UniversityDepartmentDto universityDepartmentDto) {
        UniversityDepartment universityDepartment = modelMapper.map(universityDepartmentDto,UniversityDepartment.class);
        return modelMapper.map(this.universityDepartmentRepository.save(universityDepartment)
        ,UniversityDepartmentDto.class);
    }

    @Override
    public List<UniversityDepartment> getAll() {
        return this.universityDepartmentRepository.findAll();
    }

    @Override
    public List<UniversityDepartmentDto> getAllDto() {
        return this.universityDepartmentRepository.getAllDto();
    }

    @Override
    public UniversityDepartment getByUniversityDepartmentId(Long universityDepartmentId) {
        boolean isExist = this.universityDepartmentRepository.existsById(universityDepartmentId);
        if (isExist) {
            return this.universityDepartmentRepository.getByUniversityDepartmentId(universityDepartmentId);
        } else{
            throw new InternalServerError(Message.errorUniversityDepartmentGetById);
        }
    }

    @Override
    public void deleteUniversityDepartment(Long universityDepartmentId) {
        boolean isExist = this.universityDepartmentRepository.existsById(universityDepartmentId);

        if (isExist) {
            this.universityDepartmentRepository.deleteById(universityDepartmentId);
        } else{
            throw new InternalServerError(Message.errorUniversityDepartmentGetById);
        }
    }

    @Override
    public UniversityDepartmentDto getByUniversityDepartmentDtoId(Long universityDepartmentId) {
        return modelMapper.map(universityDepartmentRepository.findById(universityDepartmentId).orElseThrow(
                () -> new NotFoundException(Message.errorUniversityDepartmentGetById))
                , UniversityDepartmentDto.class);
    }
}
