package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.config.support.MyBeanPostProcessor;
import com.fastdevelop.spring_anno.config.support.MyInstantiationAwareBeanPostProcessor;
import com.fastdevelop.spring_anno.develop.controller.UserController;
import com.fastdevelop.spring_anno.develop.dao.UserDao;
import com.fastdevelop.spring_anno.develop.service.UserService;
import org.springframework.context.annotation.*;

@Configuration
@Import(value = {
        MyBeanPostProcessor.class, MyInstantiationAwareBeanPostProcessor.class,
        UserService.class
})
@PropertySource(value = {"classpath:/app.properties"})
public class MainConfig2 {

    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public UserController userController(){
        return new UserController();
    }


}
