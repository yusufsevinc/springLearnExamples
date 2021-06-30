package com.spring.aop.around;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "logAround")
public class Log {


   @Around(value = "pointCutAround()")
   public void around(ProceedingJoinPoint proceedingJoinPoint){

      try {
         System.out.println("Around başladı");
         proceedingJoinPoint.proceed();


      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }

   }




   @Pointcut("within(com.spring.aop.around.repository.ProductRepositoryAround)")
   public void pointCutAround(){

   }
}
