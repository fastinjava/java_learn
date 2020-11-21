package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.develop.model.User;
import com.fastdevelop.spring_anno.develop.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScans(value = {
        @ComponentScan(
                basePackages = {"com.fastdevelop.spring_anno.develop"},
                includeFilters = {
                        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Controller.class),
                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {UserService.class})
                },
                useDefaultFilters = false//使用includeFilters时，必须制定禁用掉默认扫描规则，因为默认会进行指定包及其子包
        )
})
public class MainConfig1 {

    /**
     * @Bean 注册组件
     * 默认用方法名作为 bean name
     * @Bean("beanName")
     * @return
     */
//    @Bean(value = "userName")
//    public User user1(){
//        return new User("user1",11);
//    }

}
