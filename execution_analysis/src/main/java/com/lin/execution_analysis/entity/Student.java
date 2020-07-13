package com.lin.execution_analysis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/12
 * \* Time: 10:17
 * \* Description:
 * \
 */
@Data
@TableName(value = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;

    private String name;

    private Integer age;

}
