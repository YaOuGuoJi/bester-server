package com.xianbester.service.service;

import com.xianbester.api.dto.OrderRecordCountDTO;
import com.xianbester.api.dto.OrderRecordRequest;
import com.xianbester.api.service.OrderRecordService;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRecordServiceTest {
    @Resource
    private OrderRecordService orderRecordService;

    @Test
    public void townOrderRecordCountTest() {
        OrderRecordRequest request = new OrderRecordRequest();
        Date now = new Date("2018/10/30");
        request.setStartTime(new DateTime(now).toDate());
        request.setEndTime(new DateTime(now).plusDays(30).toDate());
        OrderRecordCountDTO orderRecordCountDTO = orderRecordService.townOrderRecordCount(request);
        Assert.assertNotNull(orderRecordCountDTO);
    }

}
