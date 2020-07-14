package com.lin.logic_delete;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.logic_delete.mapper")
public class LogicDeleteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogicDeleteApplication.class, args);
    }

}
