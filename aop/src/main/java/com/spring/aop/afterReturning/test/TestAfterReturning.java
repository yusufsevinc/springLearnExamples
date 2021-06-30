package com.spring.aop.afterReturning.test;

import com.spring.aop.afterReturning.appConfig.AppConfigAfterReturning;
import com.spring.aop.afterReturning.model.Product;
import com.spring.aop.afterReturning.repository.ProductRepositoryAfterReturning;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAfterReturning {

    public static void main(String[] args) {
/*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductRepositoryAround productRepository = context.getBean("productRepositoryAfterReturning", ProductRepositoryAround.class);
        Product product = new Product();
        product.setName("iphone 7");
        product.setPrice(3500);
        product.setAvaible(3);
        product.setCategory("Telefon");

        productRepository.saveProduct(product);
*/

        ConfigurableApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfigAfterReturning.class);
        ProductRepositoryAfterReturning productRepository1 = context1.getBean("productRepositoryAround", ProductRepositoryAfterReturning.class);
        Product product1 = new Product();
        product1.setName("iphone x");
        product1.setPrice(7000);
        product1.setAvaible(1);
        product1.setCategory("Telefon");

        productRepository1.saveProduct(product1);
        productRepository1.findProduct(0);


    }
}
