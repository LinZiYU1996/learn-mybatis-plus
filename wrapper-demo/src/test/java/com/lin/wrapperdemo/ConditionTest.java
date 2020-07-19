package com.lin.wrapperdemo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.wrapperdemo.entity.Dataset;
import com.lin.wrapperdemo.entity.User;
import com.lin.wrapperdemo.mapper.DatasetMapper;
import com.lin.wrapperdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private DatasetMapper mapper;

    /**
     * <p>
     * 根据 entity 条件，查询一条记录,
     * 这里和上方删除构造条件一样，只是seletOne返回的是一条实体记录，当出现多条时会报错
     * </p>
     */
    @Test
    public void test1() {

        User user = new User();

        user.setId(1);

        QueryWrapper<User> qryWrapper = new QueryWrapper<>();
        qryWrapper.eq("id", 1);

        User us = userMapper.selectOne(qryWrapper);
        log.info(us.toString());

    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     */

    @Test
    public void t2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "lqf");

        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }


    /**
     * allEq
     * allEq(Map<R, V> params)
     * allEq(Map<R, V> params, boolean null2IsNull)
     * allEq(boolean condition, Map<R, V> params, boolean null2IsNull)
     * <p>
     * 全部eq(或个别isNull)
     * 个别参数说明:
     * <p>
     * params : key为数据库字段名,value为字段值
     * null2IsNull : 为true则在map的value为null时调用 isNull 方法,为false时则忽略value为null的
     * <p>
     * 例1: allEq({id:1,name:"老王",age:null})--->id = 1 and name = '老王' and age is null
     * 例2: allEq({id:1,name:"老王",age:null}, false)--->id = 1 and name = '老王'
     */

    @Test
    public void test5() {
        Map<String, Object> m1 = new HashMap<>();
        Map<String, String> m2 = new HashMap<>();

        m1.put("age", 25);
        m1.put("bench", "good");

        QueryWrapper<Dataset> queryWrapper = new QueryWrapper<>();

        queryWrapper.allEq(m1);

        List<Dataset> datasets = mapper.selectList(queryWrapper);

        for (Dataset dataset : datasets) {
            log.info(dataset.toString());
        }

        //2020-07-09 10:15:42.506  INFO 14808 --- [           main] com.lin.wrapperdemo.ConditionTest
        // : Dataset{id=101, label=UDEAir, age=25, time=2020-07-09T14:03:53, bench=good}


    }


    /**
     * ne
     * <p>
     * ne(R column, Object val)
     * ne(boolean condition, R column, Object val)
     * 不等于 <>
     * 例: ne("name", "老王")--->name <> '老王'
     */
    @Test
    public void test6() {

        QueryWrapper<Dataset> queryWrapper = new QueryWrapper<>();

        queryWrapper.ne("bench", "good");

        List<Dataset> datasets = mapper.selectList(queryWrapper);

        for (Dataset dataset : datasets) {
            log.info(dataset.toString());
        }

    }


    /**
     * gt
     * gt(R column, Object val)
     * gt(boolean condition, R column, Object val)
     * <p>
     * 大于 >
     * 例: gt("age", 18)--->age > 18
     */


    @Test
    public void test7() {

        QueryWrapper<Dataset> queryWrapper = new QueryWrapper<>();

        queryWrapper.ge("age", 50);


        List<Dataset> datasets = mapper.selectList(queryWrapper);

        for (Dataset dataset : datasets) {
            log.info(dataset.toString());
        }


    }

    /**
     * lt
     *
     * 小于 <
     *
     * 例: lt("age", 18)--->age < 18
     *
     *
     */


    /**
     * le
     *小于等于 <=
     *
     */


    /**
     * between
     *
     * BETWEEN 值1 AND 值2
     *
     * 例: between("age", 18, 30)--->age between 18 and 30
     */


    /**
     *
     * like
     *
     * LIKE '%值%'
     *
     * 例: like("name", "王")--->name like '%王%'
     *
     *
     */

    /**
     *
     */


    @Test
    public void selectMaps() {

        QueryWrapper<Dataset> queryWrapper = new QueryWrapper<>();


        queryWrapper
                .eq("bench", "bad")
                .ge("age", 18);


        List<Map<String, Object>> maps = mapper.selectMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }


    }


}
