package com.spring.inhertance.test;

import com.spring.inhertance.inhertanceMerge.Database;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
/*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Database databaseOracle = context.getBean("oracleDatabase" ,Database.class);
        System.out.println(databaseOracle);

        System.out.println("********************************************** \n" +
                "**************************************************");

        Database databaseMySql = context.getBean("mySqlDatabase" ,Database.class);
        System.out.println(databaseMySql);

*/


        System.out.println("************ >>> Test Inhertance <<< ************* \n" +
                "**************************************************");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Database mySql = context.getBean("mySqlDatabaseList",Database.class);
        System.out.println(mySql);

        Database oracle = context.getBean("oracleDatabaseList",Database.class);
        System.out.println(oracle);
    }

}
