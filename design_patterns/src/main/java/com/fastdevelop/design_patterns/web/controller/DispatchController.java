package com.fastdevelop.design_patterns.web.controller;

import com.fastdevelop.design_patterns.service.UserService;
import com.fastdevelop.design_patterns.stragey.DispatchBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DispatchController {

    @Resource
    private UserService userService;

    @Autowired
    private DispatchBus dispatchBus;

    @Autowired
    private ApplicationContext beanFactory;

    @GetMapping("/dispatch")
    public Object dispatch(String srvCode){
        System.out.println(beanFactory);
        return dispatchBus.run(srvCode);
    }

//     @GetMapping("/dispatch")
//    public Object dispatch(String srvCode){
//        if ("userServiceRegister".equalsIgnoreCase(srvCode)) {
//            return userService.userServiceRegister();
//        }
//        if ("userServiceLogin".equalsIgnoreCase(srvCode)) {
//            return userService.userServiceLogin();
//        }
//        return "参数错误";
//    }
//


}
