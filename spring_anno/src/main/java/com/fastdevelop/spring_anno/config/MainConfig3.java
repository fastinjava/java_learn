package com.fastdevelop.spring_anno.config;

import com.fastdevelop.spring_anno.config.support.MyBeanPostProcessor;
import com.fastdevelop.spring_anno.develop.controller.UserController;
import com.fastdevelop.spring_anno.develop.util.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;

@Configuration
@ComponentScan(value = {"com.fastdevelop.spring_anno.develop.constconfig"})
@Import(value = {
        Connection.class
})
@PropertySource(value = {"classpath:/app.properties"})
public class MainConfig3 {

}
