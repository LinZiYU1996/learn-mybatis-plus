package com.lin.pagehelper_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.pagehelper_demo.mapper")
public class PagehelperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagehelperDemoApplication.class, args);
    }

}
