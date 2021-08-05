package com.intership.internshipmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto  extends UserDto{

    private String name;
    private String webAddress;
    private String address;
    private CityDto city ;


}
