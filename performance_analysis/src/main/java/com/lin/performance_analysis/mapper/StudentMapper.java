package com.lin.performance_analysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.performance_analysis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生Mapper层
 *
 * @author nieqiurong 2018/8/11 20:21.
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {


}
