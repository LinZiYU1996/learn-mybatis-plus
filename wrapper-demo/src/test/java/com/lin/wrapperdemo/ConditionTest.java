package com.lin.wrapperdemo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.wrapperdemo.entity.User;
import com.lin.wrapperdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/8
 * \* Time: 16:18
 * \* Description:
 * \
 */

@SpringBootTest
@Slf4j
public class ConditionTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void test1() {

        User user =  new User();

        user.setId(1);

        QueryWrapper<User> qryWrapper = new QueryWrapper<>();
        qryWrapper.eq("id",1);

        User us = userMapper.selectOne(qryWrapper);
        log.info(us.toString());

    }
}
