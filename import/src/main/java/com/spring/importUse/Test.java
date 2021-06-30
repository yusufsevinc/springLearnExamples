package com.spring.importUse;

import com.spring.importUse.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.importUse.*;

public class Test {

    public static void main(String[] args) {
        /*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user" , User.class);
        System.out.println(user);
        */

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean("users" , User.class);
        System.out.println(user);
    }
}
