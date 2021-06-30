package com.spring.placeholder.config;


import com.spring.placeholder.db.Database;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("db.properties")
public class AppConfig {


    @Value("${url}")
    private String dbUrl;

    @Value("${username}")
    private String dbUsername;

    @Value("${password}")
    private String dbPassword;


    @Bean( name = "database")
    public Database database(){
        Database database = new Database();
        database.setUrl(dbUrl);
        database.setUsername(dbUsername);
        database.setPassword(dbPassword);

        return database;
    }


}
