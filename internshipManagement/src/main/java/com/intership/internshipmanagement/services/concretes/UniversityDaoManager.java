package com.intership.internshipmanagement.services.concretes;

import com.intership.internshipmanagement.cores.exception.InternalServerError;
import com.intership.internshipmanagement.cores.exception.NotFoundException;
import com.intership.internshipmanagement.cores.message.Message;
import com.intership.internshipmanagement.dtos.UniversityDto;
import com.intership.internshipmanagement.models.University;
import com.intership.internshipmanagement.repositorys.UniversityRepository;
import com.intership.internshipmanagement.services.abstracts.UniversityDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Service
public class UniversityDaoManager implements UniversityDaoService {

    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UniversityDto add(UniversityDto universityDto) {
        University university = modelMapper.map(universityDto ,University.class);
        return modelMapper.map(universityRepository.save(university) ,UniversityDto.class );

    }

    @Override
    public List<University> getAll() {
        return this.universityRepository.findAll();
    }

    @Override
    public List<UniversityDto> getAllDto() {
        return this.universityRepository.getAllDto();
    }

    @Override
    public University getByUniversityId(Long universityId) {
        boolean isExist = this.universityRepository.existsById(universityId);
        if (isExist) {
            return this.universityRepository.getByUniversityId(universityId);
        } else{
            throw new InternalServerError(Message.errorUniversityGetById);
        }
    }

    @Override
    public UniversityDto getByUniversityDtoId(Long universityDtoId) {
        return modelMapper.map(universityRepository.findById(universityDtoId).orElseThrow(
                () -> new NotFoundException(Message.errorUniversityGetById))
                , UniversityDto.class);
    }

    @Override
    public void deleteUniversity(Long universityId) {
        boolean isExist = this.universityRepository.existsById(universityId);

        if (isExist) {
            this.universityRepository.deleteById(universityId);
        } else{
            throw new InternalServerError(Message.errorUniversityGetById);
        }

    }


}
