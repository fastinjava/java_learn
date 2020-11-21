package com.fastdevelop.spring_anno.tests;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.spring_anno.config.MainConfig1;
import com.fastdevelop.spring_anno.develop.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    @Test
    public void test1(){


        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig1.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        System.out.println(annotationConfigApplicationContext.getBeanDefinitionCount());
        System.out.println(JSONUtil.toJsonPrettyStr(beanDefinitionNames));
        System.out.println(JSONUtil.toJsonPrettyStr(annotationConfigApplicationContext.getBeanNamesForType(User.class)));

    }

}
