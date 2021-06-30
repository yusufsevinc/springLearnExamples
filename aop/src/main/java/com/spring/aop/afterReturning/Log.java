package com.spring.aop.afterReturning;

import com.spring.aop.afterReturning.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "logAfterReturning")
public class Log {

   @AfterReturning(value = "pointCutAfter()" ,returning = "product")
    public void afterReturning(JoinPoint joinPoint , Product product){
       System.out.println("metot retunr ettikten sonra başlıyor");
       System.out.println("Çalışan path: " + joinPoint);
       System.out.println("Return eden değer: " + product);
   }

   @Pointcut(value = "execution(public * com.spring.aop.afterReturning.repository.ProductRepositoryAfterReturning.findProduct(*))")
   public void pointCutAfter(){

   }
}
