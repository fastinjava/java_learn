package com.fastdevelop.jdk_source.util.function_;

import com.fastdevelop.jdk_source.optional_.User;

import java.util.function.Consumer;

public class UserPrintNameConsumer implements Consumer<User> {
    @Override
    public void accept(User user) {
        boolean test = new UserCheckNamePredicate().test(user);
        if (test){
            System.out.println(user.getUsername());
        }
    }
}
