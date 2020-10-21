package com.fastdevelop.java_proxy.cglibproxy;

import com.fastdevelop.java_proxy.support.BookService;

public class Test1 {
    public static void main(String[] args) {
        UserServiceCglibProxy userServiceCglibProxy = new UserServiceCglibProxy();
        BookService bookService = userServiceCglibProxy.getProxy(BookService.class);
        System.out.println(bookService.thinkInJava());
    }
}
