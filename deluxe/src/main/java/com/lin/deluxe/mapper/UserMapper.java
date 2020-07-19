package com.lin.deluxe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.deluxe.config.MyBaseMapper;
import com.lin.deluxe.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-07-08
 */
@Repository
public interface UserMapper extends MyBaseMapper<User> {

}
