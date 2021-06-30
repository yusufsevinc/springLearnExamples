package com.spring.component.test;

import com.spring.component.config.AppConfig;
import com.spring.component.db.DBConnection;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
/*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DBConnection connection = context.getBean("dbConnect" , DBConnection.class);

        connection.getDBInfo();
        context.close();

        */

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DBConnection dbConnection = context.getBean("dbConnect" , DBConnection.class);
        dbConnection.getDBInfo();
        context.close();

    }
}
