package com.fastdevelop.spring_anno.develop.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
public class UserController  implements InitializingBean, DisposableBean,ApplicationContextAware {

    private ApplicationContext applicationContext;

    public UserController(){
        System.out.println("userController 的无参构造方法");
    }

    public void initMethod(){
        System.out.println("userController initMethod");
    }

    public void destroyMethod(){
        System.out.println("userController destroyMethod");
    }

    @PostConstruct
    public void  postConstruct(){
        System.out.println("userController 的postConstruct方法");
    }

    @PreDestroy
    public void  preDestroy(){
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
}
