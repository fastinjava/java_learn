package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.config.support.MyBeanPostProcessor;
import com.fastdevelop.spring_anno.develop.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        MyBeanPostProcessor.class
})
public class MainConfig2 {

    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public UserController userController(){
        return new UserController();
    }

}
