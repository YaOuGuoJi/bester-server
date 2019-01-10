package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.service.TodayPriceAndFrequencyService;
import com.xianbester.service.dao.TodayTotalPriceAndFrequencyMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Service
@Component
public class TodayPriceAndFrequencyServiceImpl implements TodayPriceAndFrequencyService {
    @Resource
    private TodayTotalPriceAndFrequencyMapper todayTotalPriceAndFrequencyMapper;

    @Override
    public Map<String, BigDecimal> todayPriceAndFrequency(Date startTime,Date endTime) {
        return todayTotalPriceAndFrequencyMapper.todayTotalPriceAndFrequency(startTime,endTime);
    }
}
