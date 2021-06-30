package com.spring.aop.PointCut;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "logPointCut")
public class Log {

    @Before("pointCutSaveProduct()")
    public void beforeAdvice(){
        System.out.println("Veri kaydetme işlemi başlıyor...");
    }
    //@Before(value = "execution(public * com.spring.aop.aop.repository.*.deleteProduct(*))")
    //@Before(value = "execution(public * com.spring.aop.aop.repository.ProductRepositoryAround.deleteProduct(*))")
    //@Before("execution(public * findProducts())")
    @Before("pointCutProductRepository()")
    public void beforeTwoAdvice(){
        System.out.println("Veri silme işlemi başlıyor...");
    }

    @After("pointCutProductRepository()")
    public void afterAdvice(){
        System.out.println("Veri kaydetme işlemi bitti");
    }

    @Pointcut(value = "execution(public void com.spring.aop.PointCut.repository.ProductRepository.saveProduct(*))")
    public void pointCutSaveProduct(){

    }

    @Pointcut("within(com.spring.aop.PointCut.repository.ProductRepository)")
    public void pointCutProductRepository(){

    }
}
