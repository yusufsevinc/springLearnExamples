package com.intership.service.concretes;

import java.util.Optional;
import com.intership.model.Employee;
import com.intership.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Employee> optionalEmployee = employeeService.findByUsername(userName);
        if(optionalEmployee.isPresent()) {
            Employee employees = optionalEmployee.get();

            return User.builder()
                    .username(employees.getUsername())
                    .password( bCryptPasswordEncoder.encode(employees.getPassword()))
                    .accountExpired(employees.isAccountExpired())
                    .accountLocked(employees.isAccountLocked())
                    .roles(employees.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }
}
