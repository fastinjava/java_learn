package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.develop.dao.UserDao;
import com.fastdevelop.spring_anno.develop.mapper.UserMapper;
import com.fastdevelop.spring_anno.develop.model.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.fastdevelop.spring_anno.develop.service","com.fastdevelop.spring_anno.develop.dao",

        "com.fastdevelop.spring_anno.develop.mapper"
})
public class MainConfig4 {

    /**
     * spring ioc容器中假设UserDao类型的bean，不止一个
     * 自动装配时，会优先装配加@Primary的bean
     * @return
     */
//    @Primary
//    @Bean
//    public UserDao userDao1(){
//        return new UserDao();
//    }

//    @Bean("userMapper1")
//    public UserMapper userMapper(){
//        return new UserMapper();
//    }
//    @Bean
//    public UserDao userDao1(@Autowired UserMapper userMapper){
//        return new UserDao(userMapper);
//    }


    @Bean
    public Color color(UserMapper userMapper){
        return new Color(userMapper);
    }
}
