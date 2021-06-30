package com.spring.messagetrlanguage.test;

import com.spring.messagetrlanguage.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConfigurableApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        String message1 = context.getMessage("error.login.message" ,null ,Locale.US);
        System.out.println(message1);
        context1.close();

        String message = context.getMessage("error.login.message" , null ,Locale.getDefault());
        System.out.println(message);
        context.close();

    }
}
