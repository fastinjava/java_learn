package com.fastdevelop.spring_anno.develop.model;

import com.fastdevelop.spring_anno.develop.mapper.UserMapper;

public class Color {

    public Color(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
