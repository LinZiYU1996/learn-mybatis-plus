package com.lin.dynamic_tablename_demo;

import com.lin.dynamic_tablename_demo.entity.U1;
import com.lin.dynamic_tablename_demo.entity.U2;
import com.lin.dynamic_tablename_demo.mapper.U1Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicTablenameDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void t1() {

        for (int i = 0; i < 10; i++) {
            U1 u = new U1();

            u.setName(i+"  a ");
            u.insert();
        }

    }


    @Test
    public void t2() {

        for (int i = 0; i < 10; i++) {
            U2 u = new U2();

            u.setName(i+"  a ");
            u.insert();
        }

    }


    @Autowired
    private U1Mapper u1Mapper;

    @Test
    public void t3() {
        for (int i = 0; i < 6 ; i++) {
            U1 user = u1Mapper.selectById(1);
            System.err.println(user.getName());
        }
    }


}
