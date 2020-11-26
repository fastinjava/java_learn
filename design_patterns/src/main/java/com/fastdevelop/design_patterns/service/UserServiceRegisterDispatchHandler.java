package com.fastdevelop.design_patterns.service;

import com.fastdevelop.design_patterns.stragey.DispatchHandler;
import com.fastdevelop.design_patterns.stragey.SrvCodeAnnotation;

@SrvCodeAnnotation(srvCode = "userServiceRegister")
public class UserServiceRegisterDispatchHandler implements DispatchHandler {
    @Override
    public Object handle() {
        return "userServiceRegister";
    }
}
