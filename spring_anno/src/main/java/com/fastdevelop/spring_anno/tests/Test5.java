package com.fastdevelop.spring_anno.tests;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.spring_anno.config.MainConfig4;
import com.fastdevelop.spring_anno.config.MainConfig5;
import com.fastdevelop.spring_anno.develop.dao.UserDao;
import com.fastdevelop.spring_anno.develop.mapper.UserMapper;
import com.fastdevelop.spring_anno.develop.model.Color;
import com.fastdevelop.spring_anno.develop.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 测试自动装配
 */
public class Test5 {

    @Test
    public void test1() {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dev","test");
        annotationConfigApplicationContext.register(MainConfig5.class);
        annotationConfigApplicationContext.refresh();

        Map<String, DataSource> dataSourceMap = annotationConfigApplicationContext.getBeansOfType(DataSource.class);
        System.out.println(dataSourceMap.size());
        for (Map.Entry<String, DataSource> dataSourceEntry : dataSourceMap.entrySet()) {
            System.out.println(dataSourceEntry.getKey() + "----" + JSONUtil.toJsonPrettyStr(dataSourceEntry.getValue()));
        }
        annotationConfigApplicationContext.close();

    }

}
