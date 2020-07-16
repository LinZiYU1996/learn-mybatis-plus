package com.lin.resultmap_demo;

import com.lin.resultmap_demo.entity.Child;
import com.lin.resultmap_demo.entity.Man;
import com.lin.resultmap_demo.entity.Woman;
import com.lin.resultmap_demo.mapper.ChildMapper;
import com.lin.resultmap_demo.mapper.ManMapper;
import com.lin.resultmap_demo.mapper.WomanMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class ResultmapDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private ChildMapper childMapper;
    @Resource
    private ManMapper manMapper;
    @Resource
    private WomanMapper womanMapper;


    @Test
    public void t_c() {
        final Child child = childMapper.selectLinkById(1L);
        log.info("child: {}", child);
        assertThat(child).isNotNull();
        final Man laoHan = child.getLaoHan();
        assertThat(laoHan).isNotNull();
        assertThat(laoHan.getName()).isNotBlank();
        final Woman laoMa = child.getLaoMa();
        assertThat(laoMa).isNotNull();
        assertThat(laoMa.getName()).isNotBlank();
    }

}
