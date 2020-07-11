package com.lin.cruddemo;

import com.lin.cruddemo.entity.Adddress;
import com.lin.cruddemo.mapper.AdddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/10
 * \* Time: 9:08
 * \* Description:
 *
 * Active Record 演示
 *
 *
 * \
 */

@SpringBootTest
@Slf4j
public class ActiveRecordTest {


    /**
     * ActiveRecord模式：只要实体类继承一个类，并重写获取主键的值的方法，就可以使用实例对象去调用简单的增删改查方法
     *
     * Active Record 是一种数据访问设计模式，它可以帮助你实现数据对象Object到关系数据库的映射。
     *
     * 应用Active Record 时，每一个类的实例对象唯一对应一个数据库表的一行(一对一关系)。你只需继承一个abstract Active Record 类就可以使用该设计模式访问数据库，其最大的好处是使用非常简单。
     */

    @Test
    public void t1() {

        Adddress adddress = new Adddress();

        adddress.setAge(10);
        adddress.setLocation("aaasds");

        adddress.insert();
        // 成功直接拿会写的 ID
        log.info("\n插入成功 ID 为： " + adddress.getId());
    }

    @Test
    public void bDelete() {
        Adddress adddress = new Adddress();
        adddress.setId(240);
        adddress.deleteById();

    }

    @Test
    public void cUpdate() {


        Adddress adddress = new Adddress();
        adddress.setId(1);

        adddress.setAge(666);

        adddress.updateById();

    }



}
