package com.intership.internshipmanagement.controller;

import com.intership.internshipmanagement.dto.CityDto;
import com.intership.internshipmanagement.model.City;
import com.intership.internshipmanagement.service.concretes.CityDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {


    private final CityDaoService cityDaoService;

    public CityController(CityDaoService cityDaoService) {
        this.cityDaoService = cityDaoService;
    }

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
