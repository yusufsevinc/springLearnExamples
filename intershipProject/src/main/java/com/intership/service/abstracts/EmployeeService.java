package com.intership.service.abstracts;

import com.intership.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findByUsername(String username);
    void deleteByEmployeeId(Long employeeId);
    Employee getByEmployeeId(Long employeeId);
    void save(Employee employee);
    boolean userNameController(String username);
}
