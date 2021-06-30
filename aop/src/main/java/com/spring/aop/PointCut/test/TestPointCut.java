package com.spring.aop.PointCut.test;

import com.spring.aop.PointCut.appConfig.AppConfigPointCut;
import com.spring.aop.PointCut.model.Product;
import com.spring.aop.PointCut.repository.ProductRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPointCut {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductRepository productRepository = context.getBean("productRepositoryPointCut" , ProductRepository.class);
        Product product = new Product();
        product.setName("iphone 7");
        product.setPrice(3500);
        product.setAvaible(3);
        product.setCategory("Telefon");

        productRepository.saveProduct(product);


        ConfigurableApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfigPointCut.class);
        ProductRepository productRepository1 = context.getBean("productRepositoryPointCut" , ProductRepository.class);
        Product product1 = new Product();
        product1.setName("iphone x");
        product1.setPrice(7000);
        product1.setAvaible(1);
        product1.setCategory("Telefon");

        productRepository1.saveProduct(product1);


    }
}
