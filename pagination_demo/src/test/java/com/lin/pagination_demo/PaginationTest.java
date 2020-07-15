package com.lin.pagination_demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.pagination_demo.entity.User1;
import com.lin.pagination_demo.mapper.User1Mapper;
import com.lin.pagination_demo.model.MyPage;
import com.lin.pagination_demo.model.ParamSome;
import com.lin.pagination_demo.model.UserChildren;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/14
 * \* Time: 9:49
 * \* Description:
 * \
 */

@Slf4j
@SpringBootTest
public class PaginationTest {

    @Resource
    private User1Mapper mapper;

    @Test
    public void lambdaPagination() {
        Page<User1> page = new Page<>(1, 3);
        Page<User1> result = mapper.selectPage(page, Wrappers.<User1>lambdaQuery().ge(User1::getAge, 1).orderByAsc(User1::getAge));
        List<User1> u1s = result.getRecords();
        for (User1 u1 : u1s) {
            log.info(u1.toString());
        }
        assertThat(result.getTotal()).isGreaterThan(3);
        assertThat(result.getRecords().size()).isEqualTo(3);
    }

    @Test
    public void tests1() {
        log.error("----------------------------------baseMapper 自带分页-------------------------------------------------------");
        Page<User1> page = new Page<>(1, 5);
        page.addOrder(OrderItem.asc("age"));
        Page<User1> userIPage = mapper.selectPage(page, Wrappers.<User1>lambdaQuery().eq(User1::getAge, 20).like(User1::getName, "Jack"));
        assertThat(page).isSameAs(userIPage);
        log.error("总条数 -------------> {}", userIPage.getTotal());
        log.error("当前页数 -------------> {}", userIPage.getCurrent());
        log.error("当前每页显示数 -------------> {}", userIPage.getSize());
        List<User1> records = userIPage.getRecords();
        assertThat(records).isNotEmpty();

        log.error("----------------------------------json 正反序列化-------------------------------------------------------");
        String json = JSON.toJSONString(page);
        log.info("json ----------> {}", json);
        Page<User1> page1 = JSON.parseObject(json, new TypeReference<Page<User1>>() {
        });
        List<User1> records1 = page1.getRecords();
        assertThat(records1).isNotEmpty();
        assertThat(records1.get(0).getClass()).isEqualTo(User1.class);

        log.error("----------------------------------自定义 XML 分页-------------------------------------------------------");
        MyPage<User1> myPage = new MyPage<User1>(1, 5).setSelectInt(20).setSelectStr("Jack");
        ParamSome paramSome = new ParamSome(20, "Jack");
        MyPage<User1> userMyPage = mapper.mySelectPage(myPage, paramSome);
        assertThat(myPage).isSameAs(userMyPage);
        log.error("总条数 -------------> {}", userMyPage.getTotal());
        log.error("当前页数 -------------> {}", userMyPage.getCurrent());
        log.error("当前每页显示数 -------------> {}", userMyPage.getSize());
    }

    @Test
    public void tests2() {
        /* 下面的 left join 不会对 count 进行优化,因为 where 条件里有 join 的表的条件 */
        MyPage<UserChildren> myPage = new MyPage<>(1, 5);
        myPage.setSelectInt(18).setSelectStr("Jack");
        MyPage<UserChildren> userChildrenMyPage = mapper.userChildrenPage(myPage);
        List<UserChildren> records = userChildrenMyPage.getRecords();
        records.forEach(System.out::println);

        /* 下面的 left join 会对 count 进行优化,因为 where 条件里没有 join 的表的条件 */
        myPage = new MyPage<UserChildren>(1, 5).setSelectInt(18);
        userChildrenMyPage = mapper.userChildrenPage(myPage);
        records = userChildrenMyPage.getRecords();
        records.forEach(System.out::println);
    }


    @Test
    public void testMyPageMap() {
        MyPage<User1> myPage = new MyPage<User1>(1, 5).setSelectInt(20).setSelectStr("Jack");
        mapper.mySelectPageMap(myPage, Maps.newHashMap("name", "%a"));
        myPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void iPageTest() {
        IPage<User1> page = new Page<User1>(1, 5) {
            private String name = "%";

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        };

        List<User1> list = mapper.iPageSelect(page);
        System.out.println("list.size=" + list.size());
        System.out.println("page.total=" + page.getTotal());
    }



}
