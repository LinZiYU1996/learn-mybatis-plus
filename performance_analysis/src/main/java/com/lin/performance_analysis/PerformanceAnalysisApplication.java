package com.lin.performance_analysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.performance_analysis.mapper")
public class PerformanceAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceAnalysisApplication.class, args);
    }

}
