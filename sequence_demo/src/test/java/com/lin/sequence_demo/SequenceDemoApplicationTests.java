package com.lin.sequence_demo;

import com.lin.sequence_demo.entity.User;
import com.lin.sequence_demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SequenceDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(18);
        user.setEmail("test@baomidou.com");
        user.setName("sequence");
        userMapper.insert(user);
        Long id1 = user.getId();
        System.out.println(id1);
        Assert.assertTrue("sequence start with 1000", id1 >= 1000);
        user = new User();
        user.setAge(19);
        user.setEmail("test2@baomidou.com");
        user.setName("sequence2");
        userMapper.insert(user);
        Long id2 = user.getId();
        Assert.assertTrue("squence increment by 1", id2 - id1 == 1);
    }

}
