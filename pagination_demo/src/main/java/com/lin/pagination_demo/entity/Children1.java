package com.lin.pagination_demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lin
 * @since 2020-07-14
 */
public class Children1 extends Model<Children1> {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
      private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 上级ID
     */
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Children1{" +
        "id=" + id +
        ", name=" + name +
        ", userId=" + userId +
        "}";
    }
}
