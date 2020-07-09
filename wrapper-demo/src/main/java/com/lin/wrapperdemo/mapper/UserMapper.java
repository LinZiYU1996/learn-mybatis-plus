package com.lin.wrapperdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.wrapperdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-07-08
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
