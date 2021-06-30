package com.spring.importUse.config;

import org.springframework.context.annotation.Bean;
import com.spring.importUse.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean(name = "user")
    public User user(){
        User user = new User();
        user.setId(3);
        user.setName("Sevincc");

        return user;
    }
}
