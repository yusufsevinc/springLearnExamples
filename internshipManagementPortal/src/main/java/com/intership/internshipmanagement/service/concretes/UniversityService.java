package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.dto.converter.UniversityDtoConverter;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityService {


    private final UniversityRepository universityRepository;
    private final ModelMapper modelMapper;
    private UniversityDtoConverter universityDtoConverter;

    public UniversityService(UniversityRepository universityRepository,
                             ModelMapper modelMapper,
                             UniversityDtoConverter universityDtoConverter) {
        this.universityRepository = universityRepository;
        this.modelMapper = modelMapper;
        this.universityDtoConverter = universityDtoConverter;

    }

    public UniversityDto add(UniversityDto universityDto) {
        try {
            University university = modelMapper.map(universityDto ,University.class);
            return modelMapper.map(universityRepository.save(university),UniversityDto.class );
        }catch (Exception e){
            throw new InternalServerError(Message.errorUniversityAdding);
        }


    }


    public List<University> getAll() {
        return this.universityRepository.findAll();
    }


    public List<UniversityDto> getAllDto() {
        return  universityRepository
                .findAll()
                .stream()
                .map(universityDtoConverter::convert)
                .collect(Collectors.toList());
    }



    public University getByUniversityId(Long universityId) {
        boolean isExist = this.universityRepository.existsById(universityId);
        if (isExist) {
            return this.universityRepository.getByUniversityId(universityId);
        } else{
            throw new InternalServerError(Message.errorUniversityGetById);
        }
    }


    public UniversityDto getByUniversityDtoId(Long universityDtoId) {
        return modelMapper.map(universityRepository.findById(universityDtoId).orElseThrow(
                () -> new NotFoundException(Message.errorUniversityGetById))
                , UniversityDto.class);
    }


    public void deleteUniversity(Long universityId) {
        boolean isExist = this.universityRepository.existsById(universityId);

        if (isExist) {
            this.universityRepository.deleteById(universityId);
        } else{
            throw new InternalServerError(Message.errorUniversityGetById);
        }

    }


}
