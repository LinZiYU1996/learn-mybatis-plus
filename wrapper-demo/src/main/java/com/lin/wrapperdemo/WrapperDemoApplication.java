package com.lin.wrapperdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.wrapperdemo.mapper")
public class WrapperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrapperDemoApplication.class, args);
    }

}
