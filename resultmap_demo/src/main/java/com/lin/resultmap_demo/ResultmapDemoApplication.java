package com.lin.resultmap_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.resultmap_demo.mapper")
public class ResultmapDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultmapDemoApplication.class, args);
    }

}
