package com.lin.execution_analysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.execution_analysis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
