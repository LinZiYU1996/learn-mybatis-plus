package com.lin.enum_demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/12
 * \* Time: 10:02
 * \* Description:
 * \
 */
@Data
@Accessors(chain = true)
public class BaseEntity {
    private Long id;

}
