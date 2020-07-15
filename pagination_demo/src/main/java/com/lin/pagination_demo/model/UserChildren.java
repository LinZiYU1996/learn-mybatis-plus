package com.lin.pagination_demo.model;

import com.lin.pagination_demo.entity.Children1;
import com.lin.pagination_demo.entity.User1;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/7/14
 * \* Time: 9:35
 * \* Description:
 * \
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserChildren extends User1 {

    private List<Children1> c;
}