package com.lin.logic_delete;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.logic_delete.entity.Common;
import com.lin.logic_delete.mapper.CommonMapper;
import com.lin.logic_delete.mapper.Null1Mapper;
import com.lin.logic_delete.mapper.Null2Mapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class LogicDeleteApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private CommonMapper commonMapper;
    @Resource
    private Null1Mapper null1Mapper;
    @Resource
    private Null2Mapper null2Mapper;

    @Test
    public void t1() {
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Common common = new Common().setName("" + i);
            commonMapper.insert(common);
            ids.add(common.getId());
        }
        log.error("------------------------------------------------deleteById--------------------------------------------------------");
        commonMapper.deleteById(ids.remove(0));
        log.error("------------------------------------------------deleteByMap--------------------------------------------------------");
        commonMapper.deleteByMap(Maps.newHashMap("id", ids.remove(0)));
        log.error("------------------------------------------------delete--------------------------------------------------------");
        commonMapper.delete(Wrappers.<Common>query().eq("id", ids.remove(0)));
        log.error("------------------------------------------------deleteBatchIds--------------------------------------------------------");
        commonMapper.deleteBatchIds(Arrays.asList(ids.remove(0), ids.remove(0)));
        log.error("------------------------------------------------updateById--------------------------------------------------------");
        commonMapper.updateById(new Common().setId(ids.remove(0)).setName("老王"));
        log.error("------------------------------------------------update--------------------------------------------------------");
        commonMapper.update(new Common().setName("老王"), Wrappers.<Common>update().eq("id", ids.remove(0)));
        log.error("------------------------------------------------selectById--------------------------------------------------------");
        commonMapper.selectById(ids.remove(0));
        log.error("------------------------------------------------selectBatchIds--------------------------------------------------------");
        commonMapper.selectBatchIds(Arrays.asList(ids.remove(0), ids.remove(0)));
        log.error("------------------------------------------------selectByMap--------------------------------------------------------");
        commonMapper.selectByMap(Maps.newHashMap("id", ids.remove(0)));
        log.error("------------------------------------------------selectOne--------------------------------------------------------");
        commonMapper.selectOne(Wrappers.<Common>query().eq("id", ids.remove(0)));
        log.error("------------------------------------------------selectCount--------------------------------------------------------");
        commonMapper.selectCount(Wrappers.<Common>query().eq("id", ids.remove(0)));
        log.error("------------------------------------------------selectList--------------------------------------------------------");
        commonMapper.selectList(Wrappers.<Common>query().eq("id", ids.remove(0)));
        log.error("------------------------------------------------selectMaps--------------------------------------------------------");
        commonMapper.selectMaps(Wrappers.<Common>query().eq("id", ids.remove(0)));
        log.error("------------------------------------------------selectObjs--------------------------------------------------------");
        commonMapper.selectObjs(Wrappers.<Common>query().select("id").eq("id", ids.remove(0)));
        log.error("------------------------------------------------selectPage--------------------------------------------------------");
        commonMapper.selectPage(new Page<>(), Wrappers.<Common>query().eq("id", ids.remove(0)));
        log.error("------------------------------------------------selectMapsPage--------------------------------------------------------");
        commonMapper.selectMapsPage(new Page<>(), Wrappers.<Common>query().eq("id", ids.remove(0)));
    }


}
