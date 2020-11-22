package com.fastdevelop.spring_anno.config.support;

import com.fastdevelop.spring_anno.develop.model.Role;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Role> {


    /**
     * 默认放进ioc容器的bean名称是：MyFactoryBean全限定名,通过全限定名拿到的实际对象是getObject方法返回的类型
     * @return
     * @throws Exception
     */
    public Role getObject() throws Exception {
        Role role_from_myFactoryBean = new Role("role_from_MyFactoryBean");
        return role_from_myFactoryBean;
    }


    /**
     * 要注入的bean的类型
     * @return
     */
    public Class<?> getObjectType() {
        return Role.class;
    }

    /**
     * 是否单例
     * @return
     */
    public boolean isSingleton() {
        return false;
    }
}
