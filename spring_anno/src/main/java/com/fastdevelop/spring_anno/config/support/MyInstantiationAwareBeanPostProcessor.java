package com.fastdevelop.spring_anno.config.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    private static String BEAN_NAME = "userController";

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (BEAN_NAME.equalsIgnoreCase(beanName)) {
            System.out.println("userController InstantiationAwareBeanPostProcessor postProcessBeforeInstantiation");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (BEAN_NAME.equalsIgnoreCase(beanName)) {
            System.out.println("userController InstantiationAwareBeanPostProcessor postProcessAfterInstantiation");
        }
        return false;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (BEAN_NAME.equalsIgnoreCase(beanName)) {
            System.out.println("userController InstantiationAwareBeanPostProcessor postProcessPropertyValues");
        }
        return null;
    }


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
