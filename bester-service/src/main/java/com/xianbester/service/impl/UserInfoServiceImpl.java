package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.constant.BrandActionType;
import com.xianbester.api.dto.UserInfoDTO;
import com.xianbester.api.enums.UserVipLevel;
import com.xianbester.api.service.UserInfoService;
import com.xianbester.service.dao.UserInfoDao;
import com.xianbester.service.entity.UserInfoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author liuwen
 * @date 2018/11/12
 */
@Service
@Component
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfoDTO findUserInfoByUserId(int userId) {
        UserInfoEntity userInfoEntity = userInfoDao.selectById(userId);
        if (userInfoEntity == null) {
            return null;
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfoEntity, userInfoDTO);
        return userInfoDTO;
    }

    @Override
    public UserInfoDTO findUserInfoByPhoneNum(String phoneNum) {
        UserInfoEntity entity = userInfoDao.findUserInfoByPhoneNum(phoneNum);
        if (entity == null) {
            return null;
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(entity, userInfoDTO);
        return userInfoDTO;
    }

    @Override
    public int insertUserInfo(UserInfoDTO userInfoDTO) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDTO, userInfoEntity);
        return userInfoDao.insertUserInfo(userInfoEntity);
    }

    @Override
    public int updateUserInfo(UserInfoDTO userInfoDTO) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDTO, userInfoEntity);
        return userInfoDao.updateUserInfo(userInfoEntity);
    }

    @Override
    public int bindIdentityInfo(UserInfoDTO userInfoDTO) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDTO, userInfoEntity);
        return userInfoDao.bindIdentityInfo(userInfoEntity);
    }

    @Override
    public int updateUserVipLevel(int userId, UserVipLevel level) {
        UserInfoEntity userInfoEntity = userInfoDao.selectById(userId);
        if (userInfoEntity == null || userInfoEntity.getVip().equals(level.level)) {
            return 0;
        }
        return userInfoDao.updateUserVipLevel(userId, level.level);
    }

    @Override
    public int updateUserBindPublicNum(int userId, int bindPublicNum) {
        return userInfoDao.updateUserBindPublicNum(userId,bindPublicNum);
    }

    @Override
    public int updateLikeOrCollect(Integer userId, int type, String brandIds) {
        if (userId == null || type <= 0){
            return 0;
        }
        if (type == BrandActionType.PRAISE) {
            userInfoDao.updateBrandLikes(userId, StringUtils.isEmpty(brandIds) ? "" : brandIds);
        } else if (type == BrandActionType.COLLECT) {
            userInfoDao.updateBrandCollects(userId, StringUtils.isEmpty(brandIds) ? "" : brandIds);
        }
        return 0;
    }

    /**
     * 查找所有用户总数
     * @return
     */
    @Override
    public int findTotalUserNum() {
        return userInfoDao.findTotalUserNum();
    }
}
