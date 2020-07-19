package com.lin.dynamic_datasource_jar_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.dynamic_datasource_jar_demo.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-07-17
 */
public interface IUserService extends IService<User> {

    void insertBySlave1(User user);


}
