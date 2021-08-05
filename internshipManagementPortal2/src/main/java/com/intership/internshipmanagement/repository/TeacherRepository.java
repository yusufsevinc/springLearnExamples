package com.intership.internshipmanagement.repository;

import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("Select new com.intership.internshipmanagement.dto.TeacherDto(t.firstName," +
            "t.lastName , " +
            "t.email ," +
            "t.phone," +
            "t.photoURL ,"+
            "t.universityUndergraduate," +
            "t.universityDepartmentUndergraduate ," +
            "t.universityGraduate ," +
            "t.universityDepartmentGraduate," +
            "t.universityDoctorate," +
            "t.universityDepartmentDoctorate) From Teacher  t")
    List<TeacherDto> teacherGetAllDto();
    @Query("Select new com.intership.internshipmanagement.dto.TeacherDto(t.firstName," +
            "t.lastName , " +
            "t.email ," +
            "t.phone," +
            "t.photoURL ,"+
            "t.universityUndergraduate," +
            "t.universityDepartmentUndergraduate ," +
            "t.universityGraduate ," +
            "t.universityDepartmentGraduate," +
            "t.universityDoctorate," +
            "t.universityDepartmentDoctorate) From Teacher  t where t.id =:teacherId ")
    Optional<TeacherDto> getByTeacherDto(Long teacherId);


}
