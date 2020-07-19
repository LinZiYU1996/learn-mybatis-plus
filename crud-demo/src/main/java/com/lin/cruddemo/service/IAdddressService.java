package com.lin.cruddemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.cruddemo.entity.Adddress;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lin
 * @since 2020-07-05
 */
public interface IAdddressService extends IService<Adddress> {


    List<Adddress> getAll();


}
