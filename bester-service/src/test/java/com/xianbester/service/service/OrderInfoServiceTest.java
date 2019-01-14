package com.xianbester.service.service;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.xianbester.api.dto.ObjectMapDTO;
import com.xianbester.api.dto.OrderRecordDTO;
import com.xianbester.api.dto.OrderRecordRequest;
import com.xianbester.api.service.OrderRecordService;
import com.xianbester.service.entity.OrderNumberEntity;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoServiceTest {

    @Resource
    private OrderRecordService orderRecordService;

    @Test
    public void testAreaOrderRank() {
        OrderRecordRequest orderRecordRequest = new OrderRecordRequest();
        orderRecordRequest.setId(1);
        orderRecordRequest.setLimit(10);
        orderRecordRequest.setStartTime(new DateTime().minusMonths(10).toDate());
        orderRecordRequest.setEndTime(new Date());
        orderRecordRequest.setType(2);
        List<ObjectMapDTO<Integer, Object>> areaShopRankByType = orderRecordService.findAreaShopRankByType(orderRecordRequest);
        Assert.assertFalse(CollectionUtils.isEmpty(areaShopRankByType));
    }

    @Test
    public void testAdd() {
        OrderRecordDTO orderRecordDTO = new OrderRecordDTO();
        orderRecordDTO.setUserId(100000000);
        orderRecordDTO.setShopId(100001);
        orderRecordDTO.setOrderChannel("网络下单");
        orderRecordDTO.setOrderStatus("正在出库");
        orderRecordDTO.setProductType("衣服");
        orderRecordDTO.setProductList("鞋一双");
        orderRecordDTO.setPayType("微信支付");
        orderRecordDTO.setPrice(new BigDecimal(700));
        int result = orderRecordService.addOrderInfo(orderRecordDTO);
        Assert.assertTrue(result > 1);
    }

    @Test
    public void testSelect() {
        OrderRecordDTO orderRecordDTO = orderRecordService.findOrderDetailsByOrderId(4);
        Assert.assertNotNull(orderRecordDTO);
        List<OrderRecordDTO> byUser = orderRecordService.findOrdersByUserId(100000000, new DateTime().minusDays(1).toDate(), new Date());
        Assert.assertEquals(1, byUser.size());
        List<OrderRecordDTO> byShop = orderRecordService.findOrdersByShopId(100003, new DateTime().minusDays(3).toDate(), new Date());
        Assert.assertEquals(2, byShop.size());
    }

    @Test
    public void testPageFind() {
        PageInfo<OrderRecordDTO> pageInfo =
                orderRecordService.pageFindOrderRecordByUserId(100000000, 2, 1,
                        new DateTime(2000, 1, 1, 0, 0, 0).toDate(), new Date());
        Assert.assertNotNull(pageInfo);
    }
    @Test
    public void testorderTypeDistribution(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String start="1971-01-01 00:00:00";
            String end="2971-01-01 00:00:00";
            Date startUtilTime = sdf.parse(start);
            Date endUtilTime = sdf.parse(end);
            if (startUtilTime.after(endUtilTime)) {
                System.out.println("开始时间必须小于结束时间");
            }
//            Date startTime = new java.sql.Date(startUtilTime.getTime());
//            Date endTime = new java.sql.Date(endUtilTime.getTime());
            Map<String, Integer> stringIntegerMap=orderRecordService.orderTypeDistribution(startUtilTime,endUtilTime);
            for (String s : stringIntegerMap.keySet()) {
                System.out.println(s);
            }
            for (Integer value : stringIntegerMap.values()) {
                System.out.println(value);
            }
        }catch (ParseException e){
            System.out.println(e);
        }
    }
    @Test
    public void date(){
        String time = "2017-10-19";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date utilDate = sdf.parse(time);
            System.out.println(utilDate);
            Date date = new java.sql.Date(utilDate.getTime());
            System.out.println(date);
        }catch (ParseException e){
            System.out.println(e);
        }

    }

    @Test
    public void testSelectTypeCount(){
        Map<Integer,Object> typeCountMap = orderRecordService.selectTypeCount(90);
        System.out.println(typeCountMap);
    }
}
