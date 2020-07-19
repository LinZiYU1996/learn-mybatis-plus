package com.lin.deluxe;

import com.lin.deluxe.entity.Dataset;
import com.lin.deluxe.mapper.DatasetMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeluxeApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * BaseMapper提供了17个常用方法，但是这些方法并不能实现我们全部的需求，那
     * 么怎么办呢？大家肯定会想到是在xml文件中写sql语句解决。这样确实可以，因为MP是只做增强不做改变，我
     * 们完全可以按照mybatis的原来的方式来解决。不过MP也提供了另一种解决办法，那就是自定义全局操作。所谓自定义
     * 全局操作，也就是我们可以在mapper中自定义一些方法，然后通过某些操作，让自定义的这个方法也能像BaseMapper的内置方
     * 法，供全局调用。接下来就看看如何实现。
     * 根据MybatisPlus 的 DefaultSqlInjector 和 AbstractMethod 可以自定义各种你想要的 sql ,注入到全局中，相
     * 当于自定义 Mybatisplus 自动注入的方法。之前需要在 xml 中进行配置的 SQL 语句，现在通过扩展 DefaultSqlInjector
     *  和 AbstractMethod在加载 mybatis 环境时就注入。
     */
    @Autowired
    private DatasetMapper datasetMapper;


    @Test
    public void testInsert() {

        Dataset dataset = new Dataset();
        dataset.setAge(1);
        dataset.setLabel("1");
        datasetMapper.myInsertAll(dataset);


    }
}
