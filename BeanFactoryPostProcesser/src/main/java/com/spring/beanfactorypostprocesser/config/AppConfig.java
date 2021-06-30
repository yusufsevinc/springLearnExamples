package com.spring.beanfactorypostprocesser.config;

import com.spring.beanfactorypostprocesser.db.DBConnection;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean( name = "dbConnection",initMethod = "validation" , destroyMethod = "closeConnection")
    public DBConnection dbConnection(){
        DBConnection dbConnection = new DBConnection();
        dbConnection.setUrl("localhost:8080");
        dbConnection.setUsername("sevinc");
        dbConnection.setPassword("12345");

        return dbConnection;
    }

}
