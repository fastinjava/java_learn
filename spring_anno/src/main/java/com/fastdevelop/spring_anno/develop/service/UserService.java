package com.fastdevelop.spring_anno.develop.service;

import com.fastdevelop.spring_anno.develop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

//    @Qualifier("userDao")
//    @Autowired(required = false)

    @Resource(name = "userDao")
    private UserDao userDao1;

    public void setUserDao(UserDao userDao) {
        this.userDao1 = userDao;
    }

    public UserDao getUserDao() {
        return userDao1;
    }
}
