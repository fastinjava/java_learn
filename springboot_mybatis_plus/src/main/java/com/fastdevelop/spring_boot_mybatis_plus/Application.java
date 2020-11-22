package com.fastdevelop.spring_boot_mybatis_plus;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.fastdevelop.spring_boot_mybatis_plus.mapper"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
