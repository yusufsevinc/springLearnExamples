package com.intership.service.concretes;

import com.intership.model.Employee;
import com.intership.repository.EmployeeRepository;
import com.intership.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findByUsername(String username) {
        return this.employeeRepository.findByUsername(username);
    }

    @Override
    public void deleteByEmployeeId(Long employeeId) {
        this.employeeRepository.deleteByEmployeeId(employeeId);
    }

    @Override
    public Employee getByEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.getByEmployeeId(employeeId);
        return employee;
    }

    @Override
    public void save(Employee employee) {

        if (employee.getPassword() == null){
            Employee employee1 = employeeRepository.getByEmployeeId(employee.getEmployeeId());
            employee.setPassword(employee1.getPassword());
            this.employeeRepository.save(employee);

        }else if (!userNameController(employee.getUsername())){
            throw new UsernameNotFoundException("User Name is not Found");

        }else{
            this.employeeRepository.save(employee);
        }

    }

    @Override
    public boolean userNameController(String username) {
        if (employeeRepository.findByUsername(username).isPresent()){

            return false;
        }else{
            return true;
        }

    }
}
