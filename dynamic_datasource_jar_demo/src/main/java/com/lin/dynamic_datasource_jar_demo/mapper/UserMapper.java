package com.lin.dynamic_datasource_jar_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.dynamic_datasource_jar_demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-07-17
 */

@Repository
public interface UserMapper extends BaseMapper<User> {

}
