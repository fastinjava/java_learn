package com.fastdevelop.spring_anno.tests;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.spring_anno.config.MainConfig2;
import com.fastdevelop.spring_anno.config.MainConfig3;
import com.fastdevelop.spring_anno.develop.constconfig.AppConstConfig;
import com.fastdevelop.spring_anno.develop.util.Connection;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {

    @Test
    public void test(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig3.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println(JSONUtil.toJsonPrettyStr(beanDefinitionNames));


        Connection connection = ac.getBean(Connection.class);
        System.out.println(JSONUtil.toJsonPrettyStr(connection));

        System.out.println(JSONUtil.toJsonPrettyStr(ac.getBean(AppConstConfig.class)));

        ac.close();

    }

}
