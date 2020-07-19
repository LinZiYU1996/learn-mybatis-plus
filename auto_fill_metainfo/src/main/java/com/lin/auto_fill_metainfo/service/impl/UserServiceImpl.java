package com.lin.auto_fill_metainfo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.auto_fill_metainfo.entity.User;
import com.lin.auto_fill_metainfo.mapper.UserMapper;
import com.lin.auto_fill_metainfo.service.IUserService;
import org.springframework.stereotype.Service;

;

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
