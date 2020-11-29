package com.fastdevelop.spring_anno.develop.dao;

import com.fastdevelop.spring_anno.develop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    /**
     * Autowired 标在有参构造方法，其作用等同于标在普通方法上，也是给方法参数默认按照@Autowired的方式注入默认值；
     * Autowired 表在参构造方法参数上，如果UserDao只有一个有参构造器，甚至@Autowired都不用写
     * @param userMapper
     */
//    @Autowired
    public UserDao(/*@Autowired*/ UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //
//    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    /**
     * Autowired 标注在方法上，spring 装配该bean时，会自动调用方法，完成赋值，
     * 方法参数UserMapper userMapper，则会(默认按照类型)从容器中获取,优先装配@primary的bean（无视参数名称）；
     * 如果容器中不止一个，则会按照参数名称
     * 也可以指定名称@Qualifier(value = "userMapper1")获取
     * @param userMapper
     */
//    @Autowired
    public void setUserMapper(/*@Qualifier(value = "userMapper1")*/ UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void userDao(){
        System.out.println("userDao方法");
    }

}
