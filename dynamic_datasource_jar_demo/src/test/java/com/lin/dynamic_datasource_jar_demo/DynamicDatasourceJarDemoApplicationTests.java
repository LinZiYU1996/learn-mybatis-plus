package com.lin.dynamic_datasource_jar_demo;

import com.lin.dynamic_datasource_jar_demo.entity.User;
import com.lin.dynamic_datasource_jar_demo.service.IUserService;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicDatasourceJarDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private IUserService service;

    @Test
    public void t1() {


        User u = User.builder().name("asa").build();

        service.insertBySlave1(u);


    }
}
