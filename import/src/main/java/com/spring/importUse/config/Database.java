package com.spring.importUse.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.spring.importUse.*;

@Configuration
@Import(value = {Beans.class})
public class Database {

    @Bean(name = "users")
    public User users(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        User us = context.getBean("user" , User.class);
        return us;


    }
}
