package com.intership.internshipmanagement.services.concretes;

import com.intership.internshipmanagement.cores.exception.InternalServerError;
import com.intership.internshipmanagement.cores.exception.NotFoundException;
import com.intership.internshipmanagement.cores.message.Message;
import com.intership.internshipmanagement.dtos.CityDto;
import com.intership.internshipmanagement.models.City;
import com.intership.internshipmanagement.repositorys.CityRepository;
import com.intership.internshipmanagement.services.abstracts.CityDaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityDaoManager implements CityDaoService {


    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;


    @Override
    public CityDto add(CityDto cityDto) {
        City city = modelMapper.map(cityDto, City.class);
        return modelMapper.map(cityRepository.save(city), CityDto.class);
    }

    @Override
    public CityDto getByCity(Long cityId) {
        return modelMapper.map(cityRepository.findById(cityId).orElseThrow(
                () -> new NotFoundException(Message.errorCityGetById))
                , CityDto.class);
    }

    @Override
    public List<City> getAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public List<CityDto> cityDetails() {
        return this.cityRepository.cityDetails();
    }

    @Override
    public void deleteCity(Long cityId) {
        boolean isExist = this.cityRepository.existsById(cityId);

        if (isExist){
            this.cityRepository.deleteById(cityId);
        }else
            throw new InternalServerError(Message.errorCityGetById);

    }




}
