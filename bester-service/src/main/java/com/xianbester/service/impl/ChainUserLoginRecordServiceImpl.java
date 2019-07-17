package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.ChainUserLoginRecordDTO;
import com.xianbester.api.service.ChainUserLoginRecordService;
import com.xianbester.service.dao.ChainUserLoginRecordDao;
import com.xianbester.service.entity.ChainUserLoginRecordEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangqiang
 * @date 2019-07-16
 */
@Service
@Component
public class ChainUserLoginRecordServiceImpl implements ChainUserLoginRecordService {

    @Resource
    private ChainUserLoginRecordDao chainUserLoginRecordDao;

    @Override
    public int addUserLoginRecord(ChainUserLoginRecordDTO dto) {
        ChainUserLoginRecordEntity entity = new ChainUserLoginRecordEntity();
        BeanUtils.copyProperties(dto, entity);
        return chainUserLoginRecordDao.addUserLoginRecord(entity);
    }
}
