package com.xianbester.service.service;

import com.xianbester.api.dto.CountDTO;
import com.xianbester.api.service.OrderVolumeService;
import com.xianbester.service.dao.OrderVolumeDao;
import com.xianbester.service.entity.CountEntity;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderVolumeServiceTest {
    @Autowired
    private OrderVolumeService orderVolumeService;

    @Resource
    private OrderVolumeDao orderVolumeDao;

    @Test
    public void queryByFools(){
        int building = 14;
        Date todayTime = new DateTime().withTimeAtStartOfDay().toDate();
        Date nowTime = new Date();
        List<CountDTO> volumeDTOList=orderVolumeService.queryOrderByFloors(todayTime,nowTime,building);
        for (CountDTO countDTO : volumeDTOList) {
            System.out.println("楼号"+building+"层数"+countDTO.getId()+"数量"+countDTO.getResult());
        }
    }
    @Test
    public void queryByFoolsDao(){
        int building = 1;
        Date todayTime = new DateTime().withTimeAtStartOfDay().toDate();
        Date nowTime = new Date();
        List<CountEntity> volumeDTOList=orderVolumeDao.queryOrderByFloors(todayTime,nowTime,building);
        for (CountEntity countEntity : volumeDTOList) {
            System.out.println("楼号"+building+"层数"+countEntity.getId()+"数量"+countEntity.getResult());
        }
    }

}
