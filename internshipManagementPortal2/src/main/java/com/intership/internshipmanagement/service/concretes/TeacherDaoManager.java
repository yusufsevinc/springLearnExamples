package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.model.Teacher;
import com.intership.internshipmanagement.repository.TeacherRepository;
import com.intership.internshipmanagement.service.abstracts.TeacherDaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherDaoManager implements TeacherDaoService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;


    @Override
    public Teacher add(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return this.teacherRepository.findAll();
    }

    @Override
    public List<TeacherDto> getAllTeacherDto() {
        return this.teacherRepository.teacherGetAllDto();
    }

    @Override
    public TeacherDto getByTeacherDto(Long teacherId) {
        return modelMapper.map(this.teacherRepository.getByTeacherDto(teacherId).orElseThrow(
                () -> new NotFoundException(Message.errorTeacherGetById)
        ), TeacherDto.class);
    }

    @Override
    public Teacher getByTeacher(Long teacherId) {

        return this.teacherRepository.findById(teacherId).orElseThrow(
                () -> new NotFoundException(Message.errorTeacherGetById)
        );


    }

    @Override
    public void deleteTeacher(Long teacherId) {
        boolean isExist = this.teacherRepository.existsById(teacherId);
        if (isExist) {
            this.teacherRepository.deleteById(teacherId);
        } else {
            throw new InternalServerError(Message.errorTeacherGetById);
        }
    }
}
