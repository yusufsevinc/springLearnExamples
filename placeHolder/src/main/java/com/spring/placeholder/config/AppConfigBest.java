package com.spring.placeholder.config;

import com.spring.placeholder.db.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource("db.properties"),
        @PropertySource("application.properties")
})
public class AppConfigBest {
    @Autowired
    private Environment environment;

    @Bean
    public Database database(){
        Database database = new Database();
        database.setUrl(environment.getProperty("url"));
        database.setUsername(environment.getProperty("username1"));
        database.setPassword(environment.getProperty("password"));

        return database;
    }
}
