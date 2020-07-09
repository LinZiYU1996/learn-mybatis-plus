package com.lin.cruddemo;

import com.lin.cruddemo.entity.User;
import com.lin.cruddemo.mapper.UserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/8
 * \* Time: 15:48
 * \* Description:
 * \
 */

@SpringBootTest

public class UserCrudTest
{

    @Autowired
    private UserMapper userMapper;
    @Test
    public void test1() {

        for (int i = 0; i < 100 ; i++) {
            String name = RandomStringUtils.randomAlphabetic(6);
            String pwd = RandomStringUtils.randomAlphabetic(10);
            String md5Pass = DigestUtils.md5DigestAsHex(pwd.getBytes());
            User u = new User(name,md5Pass);
            userMapper.insert(u);
        }

    }
}
