package com.lin.cruddemo;

import com.lin.cruddemo.entity.Adddress;
import com.lin.cruddemo.mapper.AdddressMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CrudDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private AdddressMapper mapper;

    @Test
    public void t1() {

        for (int i = 0; i < 50; i++) {
            Adddress adddress = new Adddress("a"+i, i+100);
            mapper.insert(adddress);
        }

    }

    @Test
    public void t2() {
        List<Adddress> a = mapper.getAll();

        System.out.println(a);

    }
}
