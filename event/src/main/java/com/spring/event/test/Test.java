package com.spring.event.test;

import com.spring.event.publisher.UserSendMailPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserSendMailPublisher userSendMailPublisher = context.getBean("userSendMailPublisher" , UserSendMailPublisher.class);
        userSendMailPublisher.userRegisterMessage();

        context.close();
    }
}
