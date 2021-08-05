package com.intership.repository;

import com.intership.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {

    Optional<Employee> findByUsername(String username);
    void deleteByEmployeeId(Long employeeId);
    Employee getByEmployeeId(Long employeeId);

}
