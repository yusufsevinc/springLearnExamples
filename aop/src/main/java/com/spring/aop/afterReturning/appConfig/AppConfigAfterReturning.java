package com.spring.aop.afterReturning.appConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.spring")
@EnableAspectJAutoProxy
public class AppConfigAfterReturning {


}
