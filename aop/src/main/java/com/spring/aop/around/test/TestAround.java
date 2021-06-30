package com.spring.aop.around.test;

import com.spring.aop.around.appConfig.AppConfigAround;
import com.spring.aop.around.model.Product;
import com.spring.aop.around.repository.ProductRepositoryAround;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAround {

    public static void main(String[] args) {
/*
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductRepositoryAround productRepository = context.getBean("productRepositoryAround", ProductRepositoryAround.class);
        Product product = new Product();
        product.setName("iphone 7");
        product.setPrice(3500);
        product.setAvaible(3);
        product.setCategory("Telefon");

        productRepository.saveProduct(product);
*/

        ConfigurableApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfigAround.class);
        ProductRepositoryAround productRepository1 = context1.getBean("productRepositoryAround", ProductRepositoryAround.class);
        Product product1 = new Product();
        product1.setName("iphone x");
        product1.setPrice(7000);
        product1.setAvaible(1);
        product1.setCategory("Telefon");

        productRepository1.saveProduct(product1);
        //productRepository1.findProduct(0);


    }
}
