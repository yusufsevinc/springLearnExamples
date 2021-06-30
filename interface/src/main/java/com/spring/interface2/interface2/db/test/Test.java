package com.spring.interface2.interface2.db.test;

import com.spring.interface2.interface2.db.DBConnection;
import com.spring.interface2.interface2.db.impl.MySql;
import com.spring.interface2.interface2.db.impl.Oracle;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DBConnection mysql = context.getBean("mysql" , MySql.class);
        DBConnection oracle = context.getBean("oracle" , Oracle.class);

        mysql.openConnection();
        oracle.openConnection();


        context.close();
    }
}
