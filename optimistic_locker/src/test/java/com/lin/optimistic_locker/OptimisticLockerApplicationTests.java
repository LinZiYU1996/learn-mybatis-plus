package com.lin.optimistic_locker;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.optimistic_locker.entity.User;
import com.lin.optimistic_locker.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OptimisticLockerApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserMapper userMapper;

    @Order(0)
    @Test
    public void t1() {

        User user = new User();
        user.setAge(18);
        user.setEmail("test@baomidou.com");
        user.setName("optlocker");
        user.setVersion(1);
        userMapper.insert(user);
        Long id = user.getId();

    }


    /**
     * 批量更新带乐观锁
     * <p>
     * update(et,ew) et:必须带上version的值才会触发乐观锁
     */
    @Order(4)
    @Test
    public void testUpdateByEntitySucc() {
        QueryWrapper<User> ew = new QueryWrapper<>();
        ew.eq("version", 1);
        int count = userMapper.selectCount(ew);

        User entity = new User();
        entity.setAge(28);
        entity.setVersion(1);

        Assert.assertEquals("updated records should be same", count, userMapper.update(entity, null));
        ew = new QueryWrapper<>();
        ew.eq("version", 1);
        Assert.assertEquals("No records found with version=1", 0, userMapper.selectCount(ew).intValue());
        ew = new QueryWrapper<>();
        ew.eq("version", 2);
        Assert.assertEquals("All records with version=1 should be updated to version=2", count, userMapper.selectCount(ew).intValue());
    }


}
