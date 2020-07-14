package com.lin.id_generator;

import com.lin.id_generator.entity.User;
import com.lin.id_generator.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdGeneratorApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserMapper userMapper;

    @Test
    public void t1() {

        User user = new User();
        user.setName("靓仔");
        user.setAge(18);
        userMapper.insert(user);

    }


    @Test
    public void t2() {

        for (int i = 0; i < 25; i++) {
            User user = new User();
            user.setName("靓仔" + i);
            user.setAge(i);
            userMapper.insert(user);
        }

    }
}
