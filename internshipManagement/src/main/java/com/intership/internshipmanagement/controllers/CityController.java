package com.intership.internshipmanagement.controllers;

import com.intership.internshipmanagement.dtos.CityDto;
import com.intership.internshipmanagement.models.City;
import com.intership.internshipmanagement.services.abstracts.CityDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityDaoService cityDaoService;

    @PostMapping(value = "/add")
    public CityDto add(@RequestBody CityDto cityDto) {
        return this.cityDaoService.add(cityDto);

    }

    @GetMapping(value = "/getall")
    public List<City> getall() {
        return this.cityDaoService.getAll();
    }

    @GetMapping(value = "/getFindcity/{cityId}")
    public CityDto getByCity(@PathVariable Long cityId) {
        return this.cityDaoService.getByCity(cityId);
    }


    @GetMapping(value = "/cityDetails")
    public List<CityDto> cityDetails() {
        return this.cityDaoService.cityDetails();
    }

    @DeleteMapping(value = "/delete/{cityId}")
    public void deleteCity(@PathVariable Long cityId) {
        this.cityDaoService.deleteCity(cityId);
    }

}
