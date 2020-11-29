package com.fastdevelop.spring_anno.develop.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
public class UserController implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware, BeanFactoryAware
, EmbeddedValueResolverAware, EnvironmentAware , ApplicationEventPublisherAware,MessageSourceAware,ResourceLoaderAware {

    private ApplicationContext applicationContext;

    public UserController() {
        System.out.println("userController 的无参构造方法");
    }

    public void initMethod() {
        System.out.println("userController initMethod");
    }

    public void destroyMethod() {
        System.out.println("userController destroyMethod");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("userController 的postConstruct方法");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("userController preDestroy 方法");
    }

    public void destroy() throws Exception {
        System.out.println("UserController destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("UserController afterPropertiesSet");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("UserController ApplicationContextAware setApplicationContext");
        this.applicationContext = applicationContext;
    }

    public void setBeanName(String name) {
        System.out.println(String.format("UserController BeanNameAware setBeanName : %s",name));
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(String.format("UserController BeanFactoryAware setBeanFactory : %s",beanFactory.getClass().getSimpleName()));
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println(String.format("UserController EmbeddedValueResolverAware setEmbeddedValueResolver : %s",resolver.resolveStringValue("${server.port}")));
    }

    public void setEnvironment(Environment environment) {
        System.out.println(String.format("UserController EnvironmentAware setEnvironment : %s",environment.getProperty("os.name")));

    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println(String.format("UserController ApplicationEventPublisherAware setApplicationEventPublisher : %s",applicationEventPublisher));
    }

    public void setMessageSource(MessageSource messageSource) {
        System.out.println(String.format("UserController MessageSourceAware setMessageSource : %s",messageSource));
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println(String.format("UserController ResourceLoaderAware setResourceLoader : %s",resourceLoader));
    }
}
