package com.fastdevelop.spring_anno.config.support;

import com.fastdevelop.spring_anno.develop.model.Role;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 使用@import注解的类的注解信息
     * @param registry 注册中心
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //使用@import注解的类的注解信息
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        //获取ioc中某个BeanDefinition
        //BeanDefinition beanName = registry.getBeanDefinition("beanName");
        //获取ioc中某个BeanDefinition的个数
        int beanDefinitionCount = registry.getBeanDefinitionCount();
        //获取ioc中beanDefinitionNames
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();

        BeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.getPropertyValues().add("roleName","李付勇");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("李付勇11","java.lang.String");
        beanDefinition.setBeanClassName("com.fastdevelop.spring_anno.develop.model.Role");
        String beanName = "role_from_MyImportBeanDefinitionRegistrar";
        registry.registerBeanDefinition(beanName,beanDefinition);

    }
}
