package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.StudentDto;
import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.dto.TeacherSaveDto;
import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.dto.converter.TeacherDtoConverter;
import com.intership.internshipmanagement.model.Teacher;
import com.intership.internshipmanagement.model.University;
import com.intership.internshipmanagement.model.UniversityDegree;
import com.intership.internshipmanagement.model.UniversityDepartment;
import com.intership.internshipmanagement.repository.TeacherRepository;
import com.intership.internshipmanagement.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService  {

    private final TeacherRepository teacherRepository;
    private final TeacherDtoConverter teacherDtoConverter;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;


    
    public Teacher add(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    public Teacher addDto(TeacherSaveDto teacherSaveDto) {

        University university = this.universityService.getByUniversityId(teacherSaveDto.getUniversityId());
        UniversityDepartment universityDepartment = this.universityDepartmentService.getByUniversityDepartmentId(teacherSaveDto.getUniversityDepartmentId());
        UniversityDegree universityDegree = this.universityDegreeService.getByDegree(teacherSaveDto.getUniversityDegreeId());

        List<University> universities = new ArrayList<>();
        universities.add(university);


        List<UniversityDepartment> universityDepartments = new ArrayList<>();
        universityDepartments.add(universityDepartment);

        List<UniversityDegree> universityDegrees = new ArrayList<>();
        universityDegrees.add(universityDegree);

        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherSaveDto.getFirstName());
        teacher.setLastName(teacherSaveDto.getLastName());
        teacher.setEmail(teacherSaveDto.getEmail());
        teacher.setPassword(teacherSaveDto.getPassword());
        teacher.setPhone(teacherSaveDto.getPhone());
        teacher.setPhotoURL(teacherSaveDto.getPhotoURL());
        teacher.setUniversities(universities);
        teacher.setUniversityDepartments(universityDepartments);
        teacher.setDegrees(universityDegrees);


            return this.teacherRepository.save(teacher);


    }

    
    public List<Teacher> getAll() {
        return this.teacherRepository.findAll();
    }


    public List<TeacherDto> getAllDto() {
        return teacherRepository
                .findAll()
                .stream()
                .map(teacherDtoConverter::convert)
                .collect(Collectors.toList());
    }

    
    public Teacher getByTeacher(Long teacherId) {

        return this.teacherRepository.findById(teacherId).orElseThrow(
                () -> new NotFoundException(Message.errorTeacherGetById)
        );


    }

    
    public void deleteTeacher(Long teacherId) {
        boolean isExist = this.teacherRepository.existsById(teacherId);
        if (isExist) {
            this.teacherRepository.deleteById(teacherId);
        } else {
            throw new InternalServerError(Message.errorTeacherGetById);
        }
    }


}
