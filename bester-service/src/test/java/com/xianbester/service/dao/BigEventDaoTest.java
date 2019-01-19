package com.xianbester.service.dao;

import com.xianbester.service.entity.CountEntity;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangqiang
 * @date 2019-01-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BigEventDaoTest {

    @Resource
    private RecordMapper recordMapper;

    @Test
    public void testSelect(){
        Date start = new DateTime().withTimeAtStartOfDay().toDate();
        Date end = new DateTime().toDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  startParse = simpleDateFormat.format(start);
        String  endParse = simpleDateFormat.format(end);
        CountEntity countEntity = recordMapper.queryParticipantByTime(1, startParse, endParse);
        System.out.println(countEntity);
    }


}
