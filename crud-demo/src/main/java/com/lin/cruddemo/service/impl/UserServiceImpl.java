package com.lin.cruddemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
;
import com.lin.cruddemo.entity.User;
import com.lin.cruddemo.mapper.UserMapper;
import com.lin.cruddemo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-07-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
