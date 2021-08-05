package com.intership.internshipmanagement.repository;

import com.intership.internshipmanagement.dto.UniversityDto;
import com.intership.internshipmanagement.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    University getByUniversityId(Long universityId);

}
