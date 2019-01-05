package com.xianbester.service.service;

import com.xianbester.service.dao.OreRecordDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertOreRecord {
    @Resource
    private OreRecordDao oreRecordDao;

    @Test
    public void insertOre() {
        for (int i = 0; i < 50; i++) {
            BigDecimal ore = new BigDecimal(Math.random());
            oreRecordDao.insertUserOreByInterval(100001, "正常领取", ore, 1);
        }
    }

}
