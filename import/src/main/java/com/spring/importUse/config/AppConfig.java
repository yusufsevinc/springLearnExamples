package com.spring.importUse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {Beans.class ,Database.class})
public class AppConfig {
}
