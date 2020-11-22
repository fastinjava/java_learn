package com.fastdevelop.spring_anno.tests;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.fastdevelop.spring_anno.config.MainConfig1;
import com.fastdevelop.spring_anno.develop.model.Role;
import com.fastdevelop.spring_anno.develop.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    @Test
    public void test1(){


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig1.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
//        System.out.println(annotationConfigApplicationContext.getBeanDefinitionCount());
        System.out.println(JSONUtil.toJsonPrettyStr(beanDefinitionNames));
//        System.out.println(JSONUtil.toJsonPrettyStr(annotationConfigApplicationContext.getBeanNamesForType(User.class)));
//
        User user1 = annotationConfigApplicationContext.getBean("user1", User.class);
//        User user2 = annotationConfigApplicationContext.getBean("user1", User.class);
//        System.out.println(ObjectUtil.equal(user1,user2));

        Role role_from_myImportBeanDefinitionRegistrar = annotationConfigApplicationContext.getBean("role_from_MyImportBeanDefinitionRegistrar", Role.class);
        System.out.println(JSONUtil.toJsonPrettyStr(role_from_myImportBeanDefinitionRegistrar));


        Object bean = annotationConfigApplicationContext.getBean("com.fastdevelop.spring_anno.config.support.MyFactoryBean");
        if (bean instanceof Role){
            System.out.println("bean instanceof Role is true");
        }
        System.out.println(JSONUtil.toJsonPrettyStr(bean));

        annotationConfigApplicationContext.close();

    }

}
