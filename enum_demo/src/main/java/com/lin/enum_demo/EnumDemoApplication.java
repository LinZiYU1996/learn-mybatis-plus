package com.lin.enum_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.lin.enum_demo.mapper")
public class EnumDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnumDemoApplication.class, args);
    }

}
