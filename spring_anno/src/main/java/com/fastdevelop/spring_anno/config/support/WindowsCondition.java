package com.fastdevelop.spring_anno.config.support;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {


    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        BeanDefinitionRegistry registry = context.getRegistry();

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        Environment environment = context.getEnvironment();

        ResourceLoader resourceLoader = context.getResourceLoader();

        String osName = environment.getProperty("os.name");

        return osName.toUpperCase().contains("WINDOWS");
    }
}
