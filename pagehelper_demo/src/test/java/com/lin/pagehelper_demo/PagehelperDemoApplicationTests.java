package com.lin.pagehelper_demo;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.pagehelper_demo.entity.User;
import com.lin.pagehelper_demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class PagehelperDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserMapper mapper;

    @Test
    public void t1() {
        Page<User> mpPage = mapper.selectPage(new Page<>(1, 2), Wrappers.<User>query().eq("id", 1));
        List<User> us = mpPage.getRecords();

        for (User U : us) {
            log.info(U.toString());
        }

    }

    @Test
    void testIn() {
        List<Long> ids = Arrays.asList(1L, 2L);
        Page<User> mpPage = mapper.selectPage(new Page<>(1, 5), Wrappers.<User>query().in("id", ids));
        List<User> us = mpPage.getRecords();

        for (User U : us) {
            log.info(U.toString());
        }

        log.info("=====================================");
        // pagehelper
        PageInfo<User> info = PageHelper.startPage(1, 5)
                .doSelectPageInfo(() -> mapper.selectList(Wrappers.<User>query().in("id", ids)));

        List<User> uss = info.getList();
        for (User U : uss) {
            log.info(U.toString());
        }


    }


}
