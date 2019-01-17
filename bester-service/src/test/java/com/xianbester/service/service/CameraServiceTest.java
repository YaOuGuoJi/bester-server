package com.xianbester.service.service;

import com.google.common.collect.Maps;
import com.xianbester.api.dto.CameraDTO;
import com.xianbester.api.service.CameraRecordService;
import com.xianbester.api.service.CameraService;
import com.xianbester.api.service.OrderRecordService;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CameraServiceTest {

    @Autowired
    private CameraService cameraService;

    @Resource
    private OrderRecordService orderRecordService;

    @Test
    public void selectById(){
        CameraDTO cameraDTO = cameraService.selectByPrimaryKey(1);

        Assert.assertTrue(cameraDTO != null && "1号摄像头".equals(cameraDTO.getCName()));
    }

    @Test
    public void insertCamera(){
        CameraDTO cameraDTO = new CameraDTO();

        cameraDTO.setAreaId(2);
        cameraDTO.setCName("3号摄像头");
        cameraDTO.setCIp("12.12.14");

        int data = cameraService.insert(cameraDTO);

        Assert.assertEquals(4, data);
    }

    @Test
    public void updateCameraInfo(){
        CameraDTO cameraDTO = cameraService.selectByPrimaryKey(4);

        cameraDTO.setCIp("11.12.17");

        int data = cameraService.updateByPrimaryKeySelective(cameraDTO);

        Assert.assertEquals(1, data);
    }

    @Test
    public void deleteCameraInfo(){
        cameraService.deleteByPrimaryKey(3);
    }

    @Test
    public void selecTypeCount(){
        Map<Object,Integer> typeCountMap = orderRecordService.selectTypeCount(90);
        System.out.println(typeCountMap);
    }
}
