package com.lin.deluxe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.deluxe.entity.User;
import com.lin.deluxe.mapper.UserMapper;
import com.lin.deluxe.service.IUserService;
import org.springframework.stereotype.Service;

;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-07-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
