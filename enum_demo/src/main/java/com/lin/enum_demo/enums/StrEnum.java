package com.lin.enum_demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author miemie
 * @since 2020-06-12
 */
@Getter
@AllArgsConstructor
public enum StrEnum {

    ONE("one"),
    TWO("two");

    @EnumValue
    private final String value;
}
