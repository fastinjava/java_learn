package com.fastdevelop.spring_anno.develop.constconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class AppConstConfig {

    static String serverPort;

    @Value("${server.port}")
    public  void setServerPort(String serverPort) {
        AppConstConfig.serverPort = serverPort;
    }


}
