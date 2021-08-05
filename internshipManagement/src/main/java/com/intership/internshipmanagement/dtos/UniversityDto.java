package com.intership.internshipmanagement.dtos;



import com.intership.internshipmanagement.enums.Degree;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDto {

    private Long universityId;
    private String universityName;
    private Degree degree;
}
