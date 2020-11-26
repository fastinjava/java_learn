package com.fastdevelop.design_patterns.stragey;

import com.fastdevelop.design_patterns.utils.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private String basePackage = "com.fastdevelop.design_patterns";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String,Class> map = new HashMap<String,Class>();
        ClassScaner.scan(basePackage, SrvCodeAnnotation.class).forEach(x ->{
            String type = x.getAnnotation(SrvCodeAnnotation.class).srvCode();
            map.put(type,x);
        });
        beanFactory.registerSingleton(SrvCodeAnnotation.class.getName(), map);
    }
}
