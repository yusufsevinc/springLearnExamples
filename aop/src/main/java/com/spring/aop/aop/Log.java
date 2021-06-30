package com.spring.aop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "log")
public class Log {

    @Before(value = "execution(public void com.spring.aop.repository.ProductRepository.saveProduct(*))")
    public void beforeAdvice(){
        System.out.println("Veri kaydetme işlemi başlıyor...");
    }
    //@Before(value = "execution(public * com.spring.aop.repository.*.deleteProduct(*))")
    //@Before(value = "execution(public * com.spring.aop.repository.ProductRepository.deleteProduct(*))")
    //@Before("execution(public * findProducts())")
    @Before("execution(* findProduct(*))")
    public void beforeTwoAdvice(){
        System.out.println("Veri silme işlemi başlıyor...");
    }

    @After(value = "execution(* saveProduct(*))")
    public void afterAdvice(){
        System.out.println("Veri kaydetme işlemi bitti");
    }
}
