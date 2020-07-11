package com.lin.auto_fill_metainfo;

import com.lin.auto_fill_metainfo.entity.Dataset;
import com.lin.auto_fill_metainfo.mapper.DatasetMapper;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoFillMetainfoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private DatasetMapper mapper;


    /*
    自动填充，意味着就是设置默认值，不依赖数据库设置默认值，依赖程序实现。

     */
    @Test
    public void test() {

        Dataset dataset = new Dataset();
        dataset.setAge(1112);
        dataset.setLabel("aa121");
        mapper.insert(dataset);
    }
}
