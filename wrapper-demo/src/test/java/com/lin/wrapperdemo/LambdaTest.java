package com.lin.wrapperdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.wrapperdemo.entity.Dataset;
import com.lin.wrapperdemo.mapper.DatasetMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/9
 * \* Time: 9:53
 * \* Description:
 * \
 */

@SpringBootTest
@Slf4j
public class LambdaTest {


    @Autowired
    private DatasetMapper mapper;

    @Test
    public void t1() {
        QueryWrapper<Dataset> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda()
                .eq(Dataset::getBench, "good");

        List<Dataset> datasets = mapper.selectList(queryWrapper);

        for (Dataset dataset : datasets) {
            log.info(dataset.toString());
        }

    }


    @Test
    public void t2() {

        QueryWrapper<Dataset> queryWrapper = new QueryWrapper<>();

        queryWrapper.groupBy("age");

        List<Dataset> datasets = mapper.selectList(queryWrapper);

        for (Dataset dataset : datasets) {
            log.info(dataset.toString());
        }


    }
}
