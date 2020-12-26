package com.fastdevelop.jdk_source.util.function_;

import com.fastdevelop.jdk_source.optional_.User;

import java.util.function.Predicate;

public class UserCheckNamePredicate implements Predicate<User> {
    @Override
    public boolean test(User user) {
        return user.getUsername().contains("lif");
    }
}
