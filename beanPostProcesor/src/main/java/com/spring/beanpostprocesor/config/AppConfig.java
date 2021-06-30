package com.spring.beanpostprocesor.config;


import com.spring.beanpostprocesor.db.DBConnection;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
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
