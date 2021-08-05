package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.StudentDto;
import com.intership.internshipmanagement.dto.StudentSaveDto;
import com.intership.internshipmanagement.dto.converter.StudentDtoConverter;
import com.intership.internshipmanagement.enums.Situations;
import com.intership.internshipmanagement.model.*;
import com.intership.internshipmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService  {

    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;
    private final CompanyService companyService;
    private final DepartmentService departmentService;
    private final TeacherService teacherDaoService;
    private final UniversityService universityService;
    private final UniversityDepartmentService universityDepartmentService;
    private final UniversityDegreeService universityDegreeService;

    public Student add(StudentSaveDto studentDto) {
        Company company = this.companyService.getFindCompany(studentDto.getCompanyId());
        Department department = this.departmentService.getFindDepartment(studentDto.getDepartmentId());
        Teacher teacher = this.teacherDaoService.getByTeacher(studentDto.getTeacherId());
        University university = this.universityService.getByUniversityId(studentDto.getUniversityStudentId());
        UniversityDepartment universityDepartment = this.universityDepartmentService.getByUniversityDepartmentId(studentDto.getUniversityDepartmentStudentId());
        UniversityDegree universityDegree = this.universityDegreeService.getByDegree(studentDto.getUniversityDegreeStudentId());

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setStudentNo(studentDto.getStudentNo());
        student.setPhone(studentDto.getPhone());
        student.setClassNo(studentDto.getClassNo());
        student.setPhotoURL(studentDto.getPhotoURL());
        student.setCompany(company);
        student.setDepartment(department);
        student.setTeacher(teacher);
        student.setUniversityStudent(university);
        student.setUniversityDepartmentStudent(universityDepartment);
        student.setUniversityDegree(universityDegree);
        student.setStatus(Situations.valueOf(studentDto.getStatus()));


        try {
            return this.studentRepository.save(student);
        }catch (Exception e){
            throw new InternalServerError(Message.errorStudentAdding);
        }


    }

  
    public List<Student> getAll() {

            return this.studentRepository.findAll();



    }

  
    public List<StudentDto> getAllDto() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentDtoConverter::convert)
                .collect(Collectors.toList());
    }

  
    public Student getByStudent(Long studentId) {
        return this.studentRepository.findById(studentId).orElseThrow(
                () -> new NotFoundException(Message.errorStudentGetById)
        );
    }

  
    public void deleteStudent(Long studentId) {
        boolean isExist = this.studentRepository.existsById(studentId);

        if (isExist){
            this.studentRepository.deleteById(studentId);
        }else
            throw new InternalServerError(Message.errorStudentGetById);
    }
}


