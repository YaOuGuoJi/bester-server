package com.xianbester.api.service;

import com.xianbester.api.dto.UserInfoDTO;
import com.xianbester.api.enums.UserVipLevel;

/**
 * @author liuwen
 * @date 2018/11/12
 */
public interface UserInfoService {

    /**
     * 查询用户详细信息
     *
     * @param userId
     * @return
     */
    UserInfoDTO findUserInfoByUserId(int userId);

    /**
     * 根据手机号查询用户信息
     *
     * @param phoneNum
     * @return
     */
    UserInfoDTO findUserInfoByPhoneNum(String phoneNum);

    /**
     * 动态添加用户信息
     *
     * @param userInfoDTO
     * @return
     */
    int insertUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 修改用户信息
     *
     * @param userInfoDTO
     * @return
     */

    int updateUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 绑定身份证
     *
     * @param userInfoDTO
     * @return
     */
    int bindIdentityInfo(UserInfoDTO userInfoDTO);

    /**
     * 升级用户VIP等级
     *
     * @param userId
     * @param level
     * @return
     */
    int updateUserVipLevel(int userId, UserVipLevel level);

    /**
     * 更新绑定公众号状态
     *
     * @param userId
     * @param bindPublicNum
     * @return
     */
    int updateUserBindPublicNum(int userId, int bindPublicNum);

    /**
     * 修改用户的点赞或收藏品牌
     *
     * @param userId
     * @param type
     * @param brandIds
     * @return
     * @see com.xianbester.api.constant.BrandActionType
     */
    int updateLikeOrCollect(Integer userId, int type, String brandIds);

    /**
     * 查找所有用户总数
     *
     * @return
     */
    int findTotalUserNum();
}
