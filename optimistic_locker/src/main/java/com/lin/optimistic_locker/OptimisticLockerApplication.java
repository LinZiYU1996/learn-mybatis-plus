package com.lin.optimistic_locker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.optimistic_locker.mapper")
public class OptimisticLockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OptimisticLockerApplication.class, args);
    }

}
