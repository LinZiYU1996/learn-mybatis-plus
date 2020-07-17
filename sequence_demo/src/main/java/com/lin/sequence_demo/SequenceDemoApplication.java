package com.lin.sequence_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.sequence_demo.mapper")
public class SequenceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SequenceDemoApplication.class, args);
    }

}
