package com.intership.internshipmanagement.dto.converter;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.model.University;
import org.springframework.stereotype.Component;

@Component
public class UniversityDtoConverter {
    public UniversityDto convert(University from){
        try{
            return new UniversityDto(
                    from.getUniversityId(),
                    from.getUniversityName());



        }catch (Exception e){
            throw  new NotFoundException(Message.errorUniversityGetById);
        }
    }
}
