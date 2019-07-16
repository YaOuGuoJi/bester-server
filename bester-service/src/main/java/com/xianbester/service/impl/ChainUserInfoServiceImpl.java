package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.ChainUserInfoDTO;
import com.xianbester.api.service.ChainUserInfoService;
import com.xianbester.service.dao.ChainUserInfoDao;
import com.xianbester.service.entity.ChainUserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangqiang
 * @date 2019-07-16
 */
@Service
@Component
public class ChainUserInfoServiceImpl implements ChainUserInfoService {

    @Resource
    private ChainUserInfoDao chainUserInfoDao;

    @Override
    public ChainUserInfoDTO findUserInfoById(String id) {
        ChainUserInfo info = chainUserInfoDao.findUserInfoById(id);
        ChainUserInfoDTO dto = getChainUserInfoDTO(info);
        if (dto == null) return null;
        return dto;
    }

    @Override
    public ChainUserInfoDTO findUserInfoByUsername(String username) {
        ChainUserInfo info = chainUserInfoDao.findUserInfoByUsername(username);
        ChainUserInfoDTO dto = getChainUserInfoDTO(info);
        if (dto == null) return null;
        return dto;
    }

    @Override
    public int addUser(ChainUserInfoDTO dto) {
        ChainUserInfo entity = new ChainUserInfo();
        BeanUtils.copyProperties(dto, entity);
        return chainUserInfoDao.addUser(entity);
    }

    @Override
    public int updateUserInfoById(ChainUserInfoDTO dto) {
        ChainUserInfo entity = new ChainUserInfo();
        BeanUtils.copyProperties(dto, entity);
        return chainUserInfoDao.updateUserInfoById(entity);
    }

    private ChainUserInfoDTO getChainUserInfoDTO(ChainUserInfo info) {
        if (info == null) {
            return null;
        }
        ChainUserInfoDTO dto = new ChainUserInfoDTO();
        BeanUtils.copyProperties(info, dto);
        return dto;
    }

}
