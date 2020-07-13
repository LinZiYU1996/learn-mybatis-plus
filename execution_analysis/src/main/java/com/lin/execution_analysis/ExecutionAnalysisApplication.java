package com.lin.execution_analysis;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.execution_analysis.mapper")
public class ExecutionAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExecutionAnalysisApplication.class, args);
    }

}
