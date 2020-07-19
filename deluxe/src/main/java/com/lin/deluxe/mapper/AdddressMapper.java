package com.lin.deluxe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.deluxe.config.MyBaseMapper;
import com.lin.deluxe.entity.Adddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2020-07-05
 */

@Mapper
@Repository
public interface AdddressMapper extends MyBaseMapper<Adddress> {


    @Select("select * from adddress")
    List<Adddress> getAll();
}
