package com.fastdevelop.design_patterns.stragey;

import com.fastdevelop.design_patterns.service.UserServiceLoginDispatchHandler;
import com.fastdevelop.design_patterns.service.UserServiceRegisterDispatchHandler;
import com.sun.javafx.fxml.BeanAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class SrvCodeAnnotationUtil {
    @Autowired
    private ApplicationContext beanFactory;

    static Map<String,DispatchHandler> dispatchHandlerMap = new HashMap<>();

    static {
        UserServiceLoginDispatchHandler userServiceLoginDispatchHandler = new UserServiceLoginDispatchHandler();
        UserServiceRegisterDispatchHandler userServiceRegisterDispatchHandler = new UserServiceRegisterDispatchHandler();
        dispatchHandlerMap.put("userServiceLogin", userServiceLoginDispatchHandler);
        dispatchHandlerMap.put("userServiceRegister", userServiceRegisterDispatchHandler);
    }

//    public static DispatchHandler getDispatchandler(String srvCode){
//        DispatchHandler dispatchHandler = dispatchHandlerMap.get(srvCode);
//        return dispatchHandler;
//    }

        public  DispatchHandler getDispatchandler(String srvCode){
            Map<String,Class> map = (Map<String, Class>) beanFactory.getBean(SrvCodeAnnotation.class.getName());
            DispatchHandler handler = (DispatchHandler) beanFactory.getBean(map.get(srvCode));
            return handler;
    }

}
