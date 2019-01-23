package com.xianbester.service.service;

import com.xianbester.api.service.BigEventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zhangqiang
 * @date 2019-01-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BigEventServiceTest {

    @Resource
    private BigEventService bigEventService;

    @Test
    public void testTodayNum() {

    }

}
