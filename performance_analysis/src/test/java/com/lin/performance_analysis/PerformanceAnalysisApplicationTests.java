package com.lin.performance_analysis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.performance_analysis.entity.Student;
import com.lin.performance_analysis.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PerformanceAnalysisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test(){
        studentMapper.selectList(new QueryWrapper<>());
    }


    @Test
    public void t1() {


        for (int i = 0; i < 66; i++) {

            Student student = new Student();
            student.setAge(i);
            student.setName("a" + i);
            studentMapper.insert(student);
        }

    }

}
