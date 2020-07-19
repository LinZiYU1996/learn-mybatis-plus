package com.lin.execution_analysis;

import com.lin.execution_analysis.entity.Student;
import com.lin.execution_analysis.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExecutionAnalysisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentMapper studentMapper;


    @Test
    public void t1() {
        studentMapper.insert(new Student(1L, "test", 12));

    }

}
