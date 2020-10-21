package com.fastdevelop.java_proxy.cglibproxy;


import com.fastdevelop.java_proxy.support.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserServiceCglibProxy userServiceCglibProxy = new UserServiceCglibProxy();
        UserServiceImpl userServiceCglibProxyProxy = userServiceCglibProxy.getProxy(UserServiceImpl.class);
        System.out.println(userServiceCglibProxyProxy.sayHello("lifuyong"));
    }
}
