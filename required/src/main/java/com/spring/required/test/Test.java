package com.spring.required.test;

import com.spring.required.db.Database;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
   ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Database database = context.getBean("database" , Database.class);
        database.openConnection();

        context.close();

    }



}
