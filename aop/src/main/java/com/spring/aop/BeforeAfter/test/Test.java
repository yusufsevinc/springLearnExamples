package com.spring.aop.BeforeAfter.test;

import com.spring.aop.BeforeAfter.appConfig.AppConfig;
import com.spring.aop.BeforeAfter.model.Product;
import com.spring.aop.BeforeAfter.repository.ProductRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductRepository productRepository = context.getBean("productRepositoryAround", ProductRepository.class);
        Product product = new Product();
        product.setName("iphone 7");
        product.setPrice(3500);
        product.setAvaible(3);
        product.setCategory("Telefon");

        productRepository.saveProduct(product);


        ConfigurableApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository1 = context.getBean("productRepositoryAround", ProductRepository.class);
        Product product1 = new Product();
        product1.setName("iphone x");
        product1.setPrice(7000);
        product1.setAvaible(1);
        product1.setCategory("Telefon");

        productRepository1.saveProduct(product1);


    }
}
