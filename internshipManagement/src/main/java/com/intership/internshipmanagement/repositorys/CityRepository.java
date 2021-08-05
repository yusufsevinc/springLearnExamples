package com.intership.internshipmanagement.repositorys;

import com.intership.internshipmanagement.dtos.CityDto;
import com.intership.internshipmanagement.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("Select new com.intership.internshipmanagement.dtos.CityDto(c.cityId ," +
            " c.cityName) From City c")
    List<CityDto> cityDetails();


}
