package com.spring.autowired.test;

import com.spring.autowired.db.DBConnection;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

public class Test {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DBConnection connection = context.getBean("dbConnection" , DBConnection.class);

        connection.getDBInfo();
        context.close();

    }
}
