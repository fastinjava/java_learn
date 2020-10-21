package com.fastdevelop.java_proxy.staticproxy;

import com.fastdevelop.java_proxy.support.UserService;

public class UserServiceImplProxy
        implements UserService {

    private UserService userService;

    public UserServiceImplProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String sayHello(String username) {
        System.out.println("sayHello UserServiceImplProxy...............proxy");
        return userService.sayHello(username);
    }
}
