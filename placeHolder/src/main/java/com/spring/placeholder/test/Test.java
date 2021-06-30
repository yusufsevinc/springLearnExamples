package com.spring.placeholder.test;

import com.spring.placeholder.config.AppConfig;
import com.spring.placeholder.config.AppConfigBest;
import com.spring.placeholder.db.Database;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
/*
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Database database = context.getBean("database" , Database.class);
        database.openConnection();
       // database.closeConnection(); destroyed method olarak yazıldı
        //System.out.println(database);
        context.close(); */


        ConfigurableApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfigBest.class);
        Database database2 = context2.getBean("database" , Database.class);
        database2.openConnection();
        // database.closeConnection(); destroyed method olarak yazıldı
        //System.out.println(database);
        context2.close();
/*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Database database = context.getBean("database" , Database.class);
        database.openConnection();
        System.out.println(database);
        context.close();
*/
    }



}
