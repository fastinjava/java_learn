package com.fastdevelop.spring_anno.develop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.UUID;

/**
 * @Value 注解
 */

public class Connection {
    //注入普通字符串
    @Value("localhost")
    private String ip;
    //注入系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;


    //配置文件读取
    @Value("${server.port}")
    private String port;
    private String username;

    //注入表达式结果
    @Value("#{ 22 * 2 }")
    private String passwd;



    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
