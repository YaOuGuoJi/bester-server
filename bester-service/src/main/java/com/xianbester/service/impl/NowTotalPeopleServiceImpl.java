package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.service.NowTotalPeopleService;
import com.xianbester.service.dao.NowTotalPeopleMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Component
public class NowTotalPeopleServiceImpl implements NowTotalPeopleService {
    @Resource
    private NowTotalPeopleMapper nowTotalPeopleMapper;

    @Override
    public Map<String, Integer> todayTotalPeople() {
        return nowTotalPeopleMapper.totalPeople();
    }
}
