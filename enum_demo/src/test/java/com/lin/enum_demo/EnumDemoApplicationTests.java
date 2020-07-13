package com.lin.enum_demo;

import com.lin.enum_demo.entity.User;
import com.lin.enum_demo.enums.AgeEnum;
import com.lin.enum_demo.enums.GenderEnum;
import com.lin.enum_demo.enums.GradeEnum;
import com.lin.enum_demo.enums.StrEnum;
import com.lin.enum_demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EnumDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserMapper mapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("K神");
        user.setAge(AgeEnum.ONE);
        user.setGrade(GradeEnum.HIGH);
        user.setGender(GenderEnum.MALE);
        user.setStrEnum(StrEnum.ONE);
        user.setEmail("abc@mp.com");
        Assert.assertTrue(mapper.insert(user) > 0);
        // 成功直接拿会写的 ID
        System.err.println("\n插入成功 ID 为：" + user.getId());

        List<User> list = mapper.selectList(null);
        for (User u : list) {
            System.out.println(u);
            assertThat(u.getAge()).isNotNull();
            if (u.getId().equals(user.getId())) {
                assertThat(u.getGender()).isNotNull();
                assertThat(u.getGrade()).isNotNull();
                assertThat(u.getStrEnum()).isNotNull();
            }
        }
    }


}
