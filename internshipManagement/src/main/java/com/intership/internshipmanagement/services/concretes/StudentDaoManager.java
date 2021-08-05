package com.intership.internshipmanagement.services.concretes;

import com.intership.internshipmanagement.cores.exception.InternalServerError;
import com.intership.internshipmanagement.cores.exception.NotFoundException;
import com.intership.internshipmanagement.cores.message.Message;
import com.intership.internshipmanagement.models.Student;
import com.intership.internshipmanagement.repositorys.StudentRepository;
import com.intership.internshipmanagement.services.abstracts.StudentDaoService;
import lombok.RequiredArgsConstructor;
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
