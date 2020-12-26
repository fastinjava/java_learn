package com.fastdevelop.jdk_source.util.function_;

import com.fastdevelop.jdk_source.optional_.User;

import java.util.function.Supplier;

public class UserSupplier implements Supplier<User> {
    @Override
    public User get() {
        User user = new User();
        user.setUsername("yangguo");
        return user;
    }
}
