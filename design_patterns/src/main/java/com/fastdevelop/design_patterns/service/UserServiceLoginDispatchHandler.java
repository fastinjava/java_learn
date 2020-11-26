package com.fastdevelop.design_patterns.service;

import com.fastdevelop.design_patterns.stragey.DispatchHandler;
import com.fastdevelop.design_patterns.stragey.SrvCodeAnnotation;

@SrvCodeAnnotation(srvCode = "userServiceLogin")
public class UserServiceLoginDispatchHandler implements DispatchHandler {
    @Override
    public Object handle() {
        return "userServiceLogin";
    }
}
