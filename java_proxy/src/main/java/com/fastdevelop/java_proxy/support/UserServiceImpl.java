package com.fastdevelop.java_proxy.support;

public class UserServiceImpl
 implements UserService{
    @Override
    public String sayHello(String username) {
        return "sayHello, " + username;
    }
}
