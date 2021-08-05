package com.intership.internshipmanagement.services.abstracts;

import com.intership.internshipmanagement.dtos.CityDto;
import com.intership.internshipmanagement.models.City;


import java.util.List;

public interface CityDaoService {

    CityDto add(CityDto cityDto);
    List<City> getAll();
    CityDto getByCity(Long cityId);
    List<CityDto> cityDetails();
    void deleteCity(Long cityId);

}
