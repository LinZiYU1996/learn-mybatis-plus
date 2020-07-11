package com.lin.auto_fill_metainfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.auto_fill_metainfo.mapper")
public class AutoFillMetainfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoFillMetainfoApplication.class, args);
    }

}
