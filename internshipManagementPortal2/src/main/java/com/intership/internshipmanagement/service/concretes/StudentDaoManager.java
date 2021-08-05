package com.intership.internshipmanagement.service.concretes;

import com.intership.internshipmanagement.core.exception.InternalServerError;
import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.StudentSave;
import com.intership.internshipmanagement.model.Student;
import com.intership.internshipmanagement.repository.StudentRepository;
import com.intership.internshipmanagement.service.abstracts.CityDaoService;
import com.intership.internshipmanagement.service.abstracts.StudentDaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentDaoManager implements StudentDaoService {

    private final StudentRepository studentRepository;


    @Override
    public Student add(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getByStudent(Long studentId) {
        return this.studentRepository.findById(studentId).orElseThrow(
                () -> new NotFoundException(Message.errorStudentGetById)
        );
    }

    @Override
    public void deleteStudent(Long studentId) {
        boolean isExist = this.studentRepository.existsById(studentId);

        if (isExist){
            this.studentRepository.deleteById(studentId);
        }else
            throw new InternalServerError(Message.errorStudentGetById);
    }
}
