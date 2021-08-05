package com.intership.internshipmanagement.repositorys;

import com.intership.internshipmanagement.dtos.UniversityDto;
import com.intership.internshipmanagement.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    University getByUniversityId(Long universityId);
    @Query("select new com.intership.internshipmanagement.dtos.UniversityDto( u.universityId ,u.universityName , u.degree) from University  u")
    List<UniversityDto> getAllDto();
}
