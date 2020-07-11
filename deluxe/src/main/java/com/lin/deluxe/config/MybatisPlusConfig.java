package com.lin.deluxe.config;

import com.lin.deluxe.MyLogicSqlInjector;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/10
 * \* Time: 10:14
 * \* Description:
 * \
 */

@Configuration
@MapperScan("com.lin.deluxe.mapper")
public class MybatisPlusConfig {


    /**
     * 自定义 SqlInjector
     * 里面包含自定义的全局方法
     */
    @Bean
    public MyLogicSqlInjector myLogicSqlInjector() {
        return new MyLogicSqlInjector();
    }

}
