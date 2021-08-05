package com.intership.internshipmanagement.repositorys;

import com.intership.internshipmanagement.dtos.TeacherDto;
import com.intership.internshipmanagement.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
   /* @Query("Select new com.intership.internshipmanagement.dtos.TeacherDto(t.firstName," +
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
    @Query("Select new com.intership.internshipmanagement.dtos.TeacherDto(t.firstName," +
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
    Optional<TeacherDto> getByTeacherDto(Long teacherId);*/


}
