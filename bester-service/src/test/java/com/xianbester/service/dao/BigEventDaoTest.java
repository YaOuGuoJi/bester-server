package com.xianbester.service.dao;

import com.xianbester.service.entity.BigEventEntity;
import com.xianbester.service.entity.CountEntity;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-01-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BigEventDaoTest {

    @Resource
    private RecordMapper recordMapper;

    @Resource
    private BigEventDao bigEventDao;

    @Test
    public void testSelect(){
        Date start = new DateTime().withTimeAtStartOfDay().toDate();
        Date end = new DateTime().toDate();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        CountEntity countEntity = recordMapper.checkNumberOfParticipantsInterval(list, start, end);
        System.out.println(countEntity);
    }

    @Test
    public void testFindEventInEndPoint() {
        List<BigEventEntity> eventInEndPoint = bigEventDao.findEventInEndPoint(new Date());
        System.out.println(eventInEndPoint);
    }

    @Test
    public void testSelectByField() {
        String fieldName = "NewApply";
        String  fieldValue = "1";
        Integer eventId = 1;
        int result = bigEventDao.updateByUniqueField(fieldName, fieldValue, eventId);
        System.out.println(result);
    }

}
