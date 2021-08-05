package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityDaoService  {


    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;


    public CityDto add(CityDto cityDto) {
        City city = modelMapper.map(cityDto, City.class);
        return modelMapper.map(cityRepository.save(city), CityDto.class);
    }

    public CityDto getByCity(Long cityId) {
        return modelMapper.map(cityRepository.findById(cityId).orElseThrow(
                () -> new NotFoundException(Message.errorCityGetById))
                , CityDto.class);
    }


    public City findByCity(Long cityId) {
        return this.cityRepository.findById(cityId).orElseThrow(
                () -> new NotFoundException(Message.errorCityGetById));
    }


    public List<City> getAll() {
        return this.cityRepository.findAll();
    }


    public List<CityDto> cityDetails() {
        return this.cityRepository.cityDetails();
    }


    public void deleteCity(Long cityId) {
        boolean isExist = this.cityRepository.existsById(cityId);

        if (isExist){
            this.cityRepository.deleteById(cityId);
        }else
            throw new InternalServerError(Message.errorCityGetById);

    }




}
