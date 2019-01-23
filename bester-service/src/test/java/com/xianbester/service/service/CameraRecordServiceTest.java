package com.xianbester.service.service;

import com.xianbester.api.service.CameraRecordService;
import com.xianbester.service.dao.RecordMapper;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lizhi
 * @date 2019/01/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CameraRecordServiceTest {
    @Resource
    private CameraRecordService cameraRecordService;

    @Test
    public void totalVisitorVolumeProfile() {

        Map<String, Integer> stringIntegerMap = cameraRecordService.queryVisitorsByTime(365);
        if (stringIntegerMap.isEmpty()) {
            System.out.println("无数据");
        } else {
            for (Integer value : stringIntegerMap.values()) {
                System.out.println(value);
            }
            for (String s : stringIntegerMap.keySet()) {
                System.out.println(s);
            }
        }
           /* Date todayTime = new DateTime().withTimeAtStartOfDay().toDate();
            Date tomorrowTime = new DateTime().minusDays(988).withTimeAtStartOfDay().toDate();

            System.out.println(todayTime);
            System.out.println(tomorrowTime);

            if (tomorrowTime.after(todayTime)) {
                System.out.println("开始时间必须小于结束时间");
            }
            CountEntity countEntity=recordMapper.queryVisitorsByTime(tomorrowTime,todayTime);
            if(countEntity==null){
                System.out.println("无");
            }
                System.out.println("男"+countEntity.getId()+"女"+countEntity.getResult());*/

    }

    @Test
    public void testTodayNum() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Date start = new DateTime().withTimeAtStartOfDay().toDate();
        Date end = new Date();
        Integer integer = cameraRecordService.queryParticipantByTime(list, start, end);
        System.out.println(integer);
    }


}
