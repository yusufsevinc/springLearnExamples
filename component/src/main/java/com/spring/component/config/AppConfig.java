package com.spring.component.config;

import com.spring.component.model.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;

@Configuration
@ComponentScan(value = "com.spring")

public class AppConfig {

    @Bean
    public Database database(){
        Database database = new Database();
        database.setUrl("localhost:3232");
        database.setUsername("sevinc");
        database.setPassword("12345");

        return database;
    }


}
