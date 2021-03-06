package com.lin.dynamic_tablename_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.dynamic_tablename_demo.mapper")
public class DynamicTablenameDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicTablenameDemoApplication.class, args);
    }

}
