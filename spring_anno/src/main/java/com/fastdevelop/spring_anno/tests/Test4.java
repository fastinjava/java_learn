package com.fastdevelop.spring_anno.tests;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.spring_anno.config.MainConfig4;
import com.fastdevelop.spring_anno.develop.dao.UserDao;
import com.fastdevelop.spring_anno.develop.mapper.UserMapper;
import com.fastdevelop.spring_anno.develop.model.Color;
import com.fastdevelop.spring_anno.develop.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 测试自动装配
 */
public class Test4 {

    @Test
    public void test1(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig4.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        System.out.println(JSONUtil.toJsonPrettyStr(beanDefinitionNames));

        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        System.out.println(userService.getUserDao());
        Map<String, UserDao> userDaoMap = annotationConfigApplicationContext.getBeansOfType(UserDao.class);
        for (Map.Entry<String, UserDao> daoEntry : userDaoMap.entrySet()) {
            System.out.println(daoEntry.getKey() + "--->" + daoEntry.getValue());
        }

        UserDao userDao = annotationConfigApplicationContext.getBean(UserDao.class);
        System.out.println(userDao.getUserMapper());

        Map<String, UserMapper> userMapperMap = annotationConfigApplicationContext.getBeansOfType(UserMapper.class);
        for (Map.Entry<String, UserMapper> mapperEntry : userMapperMap.entrySet()) {
            System.out.println(mapperEntry.getKey() + "--->" + mapperEntry.getValue());
        }

        Color color = annotationConfigApplicationContext.getBean(Color.class);
        System.out.println(color.getUserMapper());

        annotationConfigApplicationContext.close();

    }

}
