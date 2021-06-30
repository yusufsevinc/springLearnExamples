package com.example.springconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConstructorTest {
    public static void main(String[] args) {
/*
        ConfigurableApplicationContext configura = new ClassPathXmlApplicationContext("dbConfig.xml");

        DBConnection dbConnection = configura.getBean("dbConnection" ,DBConnection.class);

        System.out.println(dbConnection.getPassword());
        System.out.println(dbConnection.getUrl());
        System.out.println(dbConnection.getUsername());

        System.out.println("***********************");

        DBConnection dbConnectionIndex = configura.getBean("dbConnectionIndex" , DBConnection.class);

        System.out.println(dbConnectionIndex.getUrl());
        System.out.println(dbConnectionIndex.getUsername());
        System.out.println(dbConnectionIndex.getPassword());

        System.out.println("***********************");

        DBConnection dbConnectionCustom = configura.getBean("dbConnectionCustom" , DBConnection.class);

        System.out.println(dbConnectionCustom.getUrl());
        System.out.println(dbConnectionCustom.getUsername());
        System.out.println(dbConnectionCustom.getPassword());

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ConfigrationCons.class);
        DBConnection dbConnection = context.getBean(DBConnection.class);
        System.out.println(dbConnection.getPassword());
        System.out.println(dbConnection.getUrl());
        System.out.println(dbConnection.getUsername());


        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ConfigrationCons.class);

        Database database = context.getBean("database",Database.class);
        System.out.println(database.toString());




        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dbConfig.xml");
        Database database = context.getBean("database" , Database.class);
        //database.setDatabaseName("mySql");
        System.out.println(database.toString());
 */
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AutowiringAnno.class);

        Database database = context.getBean("database",Database.class);
        System.out.println(database.toString());
    }

}
