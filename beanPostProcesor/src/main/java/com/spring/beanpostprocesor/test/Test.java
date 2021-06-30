package com.spring.beanpostprocesor.test;

import com.spring.beanpostprocesor.config.AppConfig;
import com.spring.beanpostprocesor.db.DBConnection;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DBConnection dbConnection = context.getBean("dbConnection" ,DBConnection.class);
        dbConnection.openConnection();
       // dbConnection.closeConnection(); destroyed method olarak yazıldı
        //System.out.println(dbConnection);
        context.close();
/*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DBConnection dbConnection = context.getBean("dbConnection" , DBConnection.class);
        dbConnection.openConnection();
       // dbConnection.closeConnection();
       // System.out.println(dbConnection);
        context.close();
*/
    }



}
