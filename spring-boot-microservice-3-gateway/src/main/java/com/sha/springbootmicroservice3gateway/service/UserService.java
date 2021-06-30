package com.sha.springbootmicroservice3gateway.service;

import com.sha.springbootmicroservice3gateway.model.User;
import com.sha.springbootmicroservice3gateway.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        user.setUserCreateTime(LocalDateTime.now());
        return userRepository.save(user);

    }

    @Override
    public Optional<User> findByUserUserName(String userUserName){
        return userRepository.findByUserUserName(userUserName);
    }

    @Override
    public List<User> findByAllUser(){

        return userRepository.findAll();
    }

}
