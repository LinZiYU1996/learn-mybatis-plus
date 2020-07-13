package com.lin.enum_demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.lin.enum_demo.enums.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lin
 * @since 2020-07-12
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class User extends BaseEntity {

    private String name;

    private String email;

    /**
     * IEnum接口的枚举处理
     */
    private AgeEnum age;

    /**
     * 原生枚举： 默认使用枚举值顺序： 0：MALE， 1：FEMALE
     */
    private GenderEnum gender;

    /**
     * 原生枚举（带{@link com.baomidou.mybatisplus.annotation.EnumValue}):
     * 数据库的值对应该注解对应的属性
     */
    private GradeEnum grade;

    private UserState userState;

    private StrEnum strEnum;


}
