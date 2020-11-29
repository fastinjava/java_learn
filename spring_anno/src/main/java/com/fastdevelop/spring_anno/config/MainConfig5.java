package com.fastdevelop.spring_anno.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @Profile 注解学习
 * 可以根据当前环境动态的激活和切换一系列bean的功能
 * 指定组件在哪个环境下才能够注册到ioc容器中，不指定，任何环境下都能够注册到容器中；
 * 1）、加了环境标识，只有环境被激活的时候，只有符合指定环境的bean才能被注入到ioc容器中
 * 2）、默认是default环境
 * @Profile 的标注位置
 * 1）、 配置类bean上。当标注在配置类上的时候，整个配置类的配置环境必须与当前环境一直，否则该配置类无效。
 * 2）、普通bean上面。
 */
//@Profile("dev")
@Configuration
//@ComponentScan(
//        ""
//})
@PropertySource("classpath:/app.properties")
public class MainConfig5 implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    @Profile(value = {"dev"})
    @Bean("dataSourceDev")
    public DataSource dataSourceDev(@Value("${db.passwd}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/fastdevelop_cms?useSSL=false&serverTimezone=UTC");
        dataSource.setDriverClass(resolver.resolveStringValue("${db.driver}"));
        return dataSource;
    }

    @Profile(value = {"test"})
    @Bean("dataSourceTest")
    public DataSource dataSourceTest() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/fastdevelop_cms?useSSL=false&serverTimezone=UTC");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Profile(value = {"prod"})
    @Bean("dataSourceProd")
    public DataSource dataSourceProd() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/fastdevelop_cms?useSSL=false&serverTimezone=UTC");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }
}
