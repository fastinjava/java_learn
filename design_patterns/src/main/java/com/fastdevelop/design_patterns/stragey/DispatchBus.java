package com.fastdevelop.design_patterns.stragey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispatchBus {

    @Autowired
    private SrvCodeAnnotationUtil srvCodeAnnotationUtil;

    public Object run(String srvCode){
        DispatchHandler dispatchandler = srvCodeAnnotationUtil.getDispatchandler(srvCode);
        Object result = dispatchandler.handle();
        return result;
    }
}
