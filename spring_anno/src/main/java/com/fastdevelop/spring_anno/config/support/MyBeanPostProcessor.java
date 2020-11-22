package com.fastdevelop.spring_anno.config.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" MyBeanPostProcessor postProcessBeforeInitialization 方法 " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" MyBeanPostProcessor postProcessAfterInitialization 方法 " + beanName);
        return bean;
    }
}
