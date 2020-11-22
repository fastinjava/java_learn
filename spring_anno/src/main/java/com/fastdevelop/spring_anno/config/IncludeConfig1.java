package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.develop.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IncludeConfig1 {

    @Bean
    public Role role(){
        return new Role("test_role");
    }

}
