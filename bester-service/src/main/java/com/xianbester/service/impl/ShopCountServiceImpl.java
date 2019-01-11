package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.constant.OrderStatus;
import com.xianbester.api.dto.ShopCountDTO;
import com.xianbester.api.service.ShopCountService;
import com.xianbester.service.dao.ShopCountMapper;
import com.xianbester.service.entity.ShopCountEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Component
public class ShopCountServiceImpl implements ShopCountService {
    @Resource
    private ShopCountMapper shopCountMapper;

    @Override
    public List<ShopCountDTO> ordersFinished(int shopId, Date startTime, Date endTime) {
        List<ShopCountEntity> entities = shopCountMapper.ordersFinished(shopId, startTime, endTime);
        return BeansListUtils.copyListProperties(entities, ShopCountDTO.class);
    }

    @Override
    public List<ShopCountDTO> ordersCanceled(int shopId, Date startTime, Date endTime) {
        List<ShopCountEntity> entities = shopCountMapper.ordersCanceled(shopId, startTime, endTime);
        return BeansListUtils.copyListProperties(entities, ShopCountDTO.class);
    }

    @Override
    public List<ShopCountDTO> ordersByHours(int shopId, Date startTime, Date endTime) {
        List<ShopCountEntity> entities = shopCountMapper.ordersByHours(shopId, startTime, endTime);
        return BeansListUtils.copyListProperties(entities, ShopCountDTO.class);
    }

    @Override
    public List<ShopCountDTO> ordersByMonthOrDay(int shopId, int year, int month) {
        List<ShopCountEntity> orderNumAndAmount = shopCountMapper.ordersByMonthOrDay(shopId, year, month, OrderStatus.COMPLETE);
        return BeansListUtils.copyListProperties(orderNumAndAmount, ShopCountDTO.class);
    }

    @Override
    public List<ShopCountDTO> goodsSellTypeCount(int shopId, Date startTime, Date endTime) {
        List<ShopCountEntity> entities = shopCountMapper.goodsSellTypeCount(shopId, startTime, endTime);
        return BeansListUtils.copyListProperties(entities, ShopCountDTO.class);
    }

}
