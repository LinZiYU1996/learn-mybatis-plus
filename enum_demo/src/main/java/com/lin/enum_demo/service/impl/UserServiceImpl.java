package com.lin.enum_demo.service.impl;

import com.lin.enum_demo.entity.User;
import com.lin.enum_demo.mapper.UserMapper;
import com.lin.enum_demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
