package com.fastdevelop.design_patterns.stragey;

import com.fastdevelop.design_patterns.utils.ClassScanner;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private String basePackage = "com.fastdevelop.design_patterns";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        Map<String, Class> map = new HashMap<String, Class>();
        ClassScanner.scan(basePackage, SrvCodeAnnotation.class).forEach(x -> {
            String type = x.getAnnotation(SrvCodeAnnotation.class).srvCode();
            map.put(type, x);
        });
        beanFactory.registerSingleton(SrvCodeAnnotation.class.getName(),map);
        if (!ObjectUtils.isEmpty(map) && map.size() > 0) {
            for (Map.Entry<String, Class> entry : map.entrySet()) {
                try {
                    beanFactory.registerSingleton(entry.getKey(), entry.getValue().newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
