package com.spring.beanfactorypostprocesser.bean_factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;
import java.util.List;

public class BeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        List<String> beans = Arrays.asList(beanFactory.getBeanDefinitionNames());

        for (String bean: beans
             ) {
            System.out.println(bean);

        }

        int beanCount = beanFactory.getBeanDefinitionCount();
        System.out.println("Tanımlanan bean sayısı: " + beanCount);
    }
}
