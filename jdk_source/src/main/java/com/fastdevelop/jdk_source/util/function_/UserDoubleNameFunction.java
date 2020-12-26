package com.fastdevelop.jdk_source.util.function_;

import java.util.function.Function;

public class UserDoubleNameFunction implements Function<String,String> {
    @Override
    public String apply(String originalName) {
        return originalName + "-" + originalName;
    }
}
