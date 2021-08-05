package com.intership.internshipmanagement.service.abstracts;

import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.model.City;


import java.util.List;

public interface CityDaoService {

    CityDto add(CityDto cityDto);
    List<City> getAll();
    CityDto getByCity(Long cityId);
    List<CityDto> cityDetails();
    void deleteCity(Long cityId);

}
