package com.example.springconstructor;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiringAnno {


    @Bean(name = "dbConnection")
    public DBConnection dbConnection(){

        DBConnection dbConnection = new DBConnection();
        dbConnection.setPassword("12345");
        dbConnection.setUrl("localhost:8080");
        dbConnection.setUsername("sevinc");

        return dbConnection;
    }


    @Bean(name = "dbConnectionRef")
    public DBConnection dbConnection2(){

        DBConnection dbConnection = new DBConnection();
        dbConnection.setPassword("12345");
        dbConnection.setUrl("localhost:8080");
        dbConnection.setUsername("sevinc");

        return dbConnection;
    }

    @Bean(name = "database" ,autowire =  Autowire.BY_NAME)
    public Database database(){
        Database database = new Database();
        database.setDatabaseName("mysql");

        return database;
    }
}
