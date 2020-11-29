package com.fastdevelop.spring_anno.tests;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.spring_anno.config.MainConfig2;
import com.fastdevelop.spring_anno.develop.dao.UserDao;
import com.fastdevelop.spring_anno.develop.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

    @Test
    public void test(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println(JSONUtil.toJsonPrettyStr(beanDefinitionNames));
        ac.close();

    }

}
