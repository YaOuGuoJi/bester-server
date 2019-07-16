package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.ChainUserinfoDTO;
import com.xianbester.api.service.ChainUserInfoService;
import com.xianbester.service.dao.ChainUserInfoDao;
import com.xianbester.service.entity.ChainUserinfo;
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
    public ChainUserinfoDTO findUserInfoById(String id) {
        ChainUserinfo info = chainUserInfoDao.findUserInfoById(id);
        ChainUserinfoDTO dto = getChainUserInfoDTO(info);
        if (dto == null) return null;
        return dto;
    }

    @Override
    public ChainUserinfoDTO findUserInfoByUsername(String username) {
        ChainUserinfo info = chainUserInfoDao.findUserInfoByUsername(username);
        ChainUserinfoDTO dto = getChainUserInfoDTO(info);
        if (dto == null) return null;
        return dto;
    }

    @Override
    public int addUser(ChainUserinfoDTO dto) {
        ChainUserinfo entity = new ChainUserinfo();
        BeanUtils.copyProperties(dto, entity);
        return chainUserInfoDao.addUser(entity);
    }

    @Override
    public int updateUserInfoById(ChainUserinfoDTO dto) {
        ChainUserinfo entity = new ChainUserinfo();
        BeanUtils.copyProperties(dto, entity);
        return chainUserInfoDao.updateUserInfoById(entity);
    }

    private ChainUserinfoDTO getChainUserInfoDTO(ChainUserinfo info) {
        if (info == null) {
            return null;
        }
        ChainUserinfoDTO dto = new ChainUserinfoDTO();
        BeanUtils.copyProperties(info, dto);
        return dto;
    }

}
