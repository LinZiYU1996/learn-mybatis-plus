package com.lin.wrapperdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.wrapperdemo.entity.Dataset;
import com.lin.wrapperdemo.mapper.DatasetMapper;
import com.lin.wrapperdemo.service.IDatasetService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-07-09
 */
@Service
public class DatasetServiceImpl extends ServiceImpl<DatasetMapper, Dataset> implements IDatasetService {

}
