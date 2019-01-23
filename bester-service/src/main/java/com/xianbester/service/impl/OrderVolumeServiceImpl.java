package com.xianbester.service.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.xianbester.api.dto.CountDTO;
import com.xianbester.api.dto.OrderVolumeDTO;
import com.xianbester.api.service.OrderVolumeService;
import com.xianbester.service.dao.OrderVolumeDao;
import com.xianbester.service.entity.CountEntity;
import com.xianbester.service.entity.OrderVolumeEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 */
@Service
@Component
public class OrderVolumeServiceImpl implements OrderVolumeService {
    @Resource
    private OrderVolumeDao orderVolumeDao;

    @Override
    public List<OrderVolumeDTO> queryOrderByArea(Date start, Date end) {
        List<OrderVolumeEntity> volumeEntityList=orderVolumeDao.queryOrderByArea(start,end);
        if(CollectionUtils.isEmpty(volumeEntityList)){
            return Lists.newArrayList();
        }
        return BeansListUtils.copyListProperties(volumeEntityList,OrderVolumeDTO.class);
    }

    @Override
    public List<CountDTO> queryOrderByBuilding(Date start, Date end) {
        List<CountEntity> countEntityList=orderVolumeDao.queryOrderByBuilding(start,end);
        if(CollectionUtils.isEmpty(countEntityList)){
            return Lists.newArrayList();
        }
        return BeansListUtils.copyListProperties(countEntityList,CountDTO.class);
    }

    @Override
    public List<CountDTO> queryOrderByFloors(Date start, Date end, Integer building) {
        List<CountEntity> countEntityList=orderVolumeDao.queryOrderByFloors(start,end,building);
        if(CollectionUtils.isEmpty(countEntityList)){
            return Lists.newArrayList();
        }
        return BeansListUtils.copyListProperties(countEntityList,CountDTO.class);
    }
}
