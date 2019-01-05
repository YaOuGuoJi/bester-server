package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.BusinessInfoDTO;
import com.xianbester.api.service.BusinessInfoService;
import com.xianbester.service.dao.BusinessInfoDao;
import com.xianbester.service.entity.BusinessInfoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yanrui
 */
@Service
@Component
public class BusinessInfoServiceImpl implements BusinessInfoService {

    @Resource
    private BusinessInfoDao businessInfoDao;

    @Override
    public Integer insertBusinessInfo(BusinessInfoDTO businessInfoDTO) {
        BusinessInfoEntity businessInfoEntity = new BusinessInfoEntity();
        BeanUtils.copyProperties(businessInfoDTO,businessInfoEntity);
        businessInfoDao.insertBusinessInfo(businessInfoEntity);
        return businessInfoEntity.getId();
    }
}
