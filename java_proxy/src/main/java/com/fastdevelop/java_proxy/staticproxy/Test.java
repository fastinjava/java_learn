package com.fastdevelop.java_proxy.staticproxy;

import com.fastdevelop.java_proxy.support.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserServiceImplProxy userServiceImplProxy = new UserServiceImplProxy(new UserServiceImpl());
        System.out.println(userServiceImplProxy.sayHello("lifuyong"));
    }
}
