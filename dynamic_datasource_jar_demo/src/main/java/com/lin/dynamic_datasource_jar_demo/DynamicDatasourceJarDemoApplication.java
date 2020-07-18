package com.lin.dynamic_datasource_jar_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.dynamic_datasource_jar_demo.mapper")
public class DynamicDatasourceJarDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceJarDemoApplication.class, args);
    }

}
