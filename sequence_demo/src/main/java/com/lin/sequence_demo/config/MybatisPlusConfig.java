package com.lin.sequence_demo.config;

import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/16
 * \* Time: 9:37
 * \* Description:
 * \
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * sequence主键，需要配置一个主键生成器
     * 配合实体类注解 {@link KeySequence} + {@link TableId} type=INPUT
     *
     * @return
     */
    @Bean
    public H2KeyGenerator h2KeyGenerator() {
        return new H2KeyGenerator();
    }

}
