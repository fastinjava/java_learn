package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.config.support.MyCustomTypeFilter;
import com.fastdevelop.spring_anno.develop.model.User;
import com.fastdevelop.spring_anno.develop.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScans(value = {
        @ComponentScan(
                basePackages = {"com.fastdevelop.spring_anno.develop"},
                includeFilters = {
                        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Controller.class),
//                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {UserService.class}),
//                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyCustomTypeFilter.class})
                },
                useDefaultFilters = false//使用includeFilters时，必须制定禁用掉默认扫描规则，因为默认会进行指定包及其子包
        )
})
public class MainConfig1 {

    /**
     * @Bean 注册组件
     * 默认用方法名作为 bean name
     * @Bean("beanName")
     *
     * @Scope():指定作用域，默认是ConfigurableBeanFactory.SCOPE_SINGLETON 单实例的 "singleton"
     * 总共有以下几种作用域类型：
     * ConfigurableBeanFactory#SCOPE_SINGLETON  “singleton”  单例(默认),ioc容器启动会调用构造方法创建对象，之后每次从容其中获取该类型的对象的时候，也不会调用创建方法
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE   “prototype” 多例,ioc容器只会在使用时创建，何时用何时创建，之后每次从容其中获取该类型的对象的时候，均会调用创建方法
     *
     * WebApplicationContext#SCOPE_REQUEST       “request”   同一次请求创建一次
     * WebApplicationContext#SCOPE_SESSION       “session”   同一个session创建一次
     *
     * @return
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(value = "user1")
    public User user1(){
        System.out.println("给spring容器添加对象");
        return new User("user1",11);
    }

}
