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
 * \* Time: 10:58
 * \* Description:
 * \
 */


@SpringBootTest
@Slf4j
public class WrapperTest {

    @Autowired
    private DatasetMapper mapper;


    @Test
    public void tests() {

        System.out.println("----- 普通查询 ------");
        List<Dataset> plainUsers = mapper.selectList(new QueryWrapper<Dataset>().eq("id", 150));
        List<Dataset> lambdaUsers = mapper.selectList(new QueryWrapper<Dataset>().lambda().eq(Dataset::getId, 150));
        for (Dataset dataset : plainUsers) {
            log.info(dataset.toString());
        }
        log.info("========================================================================");

        for (Dataset dataset : lambdaUsers) {
            log.info(dataset.toString());
        }
        log.info("========================================================================");

        System.out.println("----- 带子查询(sql注入) ------");

        List<Dataset> plainUsers2 = mapper.selectList(new QueryWrapper<Dataset>()
                .inSql("id", "select id from dataset where id = 150"));

        for (Dataset dataset : plainUsers2) {
            log.info(dataset.toString());
        }
        log.info("========================================================================");


        System.out.println("----- 带嵌套查询 ------");
        List<Dataset> plainUsers3 = mapper.selectList(new QueryWrapper<Dataset>()
                .nested(i -> i.eq("id", 150).or().eq("id", 156))
                .and(i -> i.ge("age", 20)));

        for (Dataset dataset : plainUsers3) {
            log.info(dataset.toString());
        }

        log.info("========================================================================");

    }




}
