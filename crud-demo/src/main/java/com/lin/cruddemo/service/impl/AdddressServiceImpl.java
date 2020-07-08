package com.lin.cruddemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.cruddemo.entity.Adddress;
import com.lin.cruddemo.mapper.AdddressMapper;
import com.lin.cruddemo.service.IAdddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-07-05
 */
@Service
public class AdddressServiceImpl extends ServiceImpl<AdddressMapper, Adddress> implements IAdddressService {

    @Autowired
    private AdddressMapper adddressMapper;


    @Override
    public List<Adddress> getAll() {
        return adddressMapper.getAll();
    }
}
