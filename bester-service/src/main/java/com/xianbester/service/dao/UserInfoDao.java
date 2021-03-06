package com.xianbester.service.dao;

import com.xianbester.service.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangqiang
 */
public interface UserInfoDao {

    /**
     * 动态添加用户信息
     *
     * @param userInfoEntity
     * @return
     */
    int insertUserInfo(@Param("userInfo") UserInfoEntity userInfoEntity);

    /**
     * 根据userId查询
     *
     * @param userId
     * @return
     */
    UserInfoEntity selectById(@Param("userId") int userId);

    /**
     * 根据手机号查询用户信息
     *
     * @param phoneNum
     * @return
     */
    UserInfoEntity findUserInfoByPhoneNum(@Param("phoneNum") String phoneNum);

    /**
     * 用户信息修改
     *
     * @param userInfoEntity
     * @return
     */
    int updateUserInfo(@Param("userInfoEntity") UserInfoEntity userInfoEntity);

    /**
     * 绑定身份证信息
     *
     * @param userInfoEntity
     * @return
     */
    int bindIdentityInfo(@Param("userInfoEntity") UserInfoEntity userInfoEntity);

    /**
     * 升级会员等级
     *
     * @param userId
     * @param level
     * @return
     */
    int updateUserVipLevel(@Param("userId") int userId, @Param("level") int level);

    /**
     * 更新绑定公众号状态
     *
     * @param userId
     * @param bindPublicNum
     * @return
     */
    int updateUserBindPublicNum(@Param("userId") int userId, @Param("bindPublicNum") int bindPublicNum);

    /**
     * 修改用户点赞列表
     *
     * @param userId
     * @param brandLikeList
     * @return
     */
    int updateBrandLikes(@Param("userId") Integer userId, @Param("brandLikeList") String brandLikeList);

    /**
     * 修改用户收藏列表
     *
     * @param userId
     * @param brandCollectList
     * @return
     */
    int updateBrandCollects(@Param("userId") Integer userId, @Param("brandCollectList") String brandCollectList);

    /**
     * 查找所有用户总数
     *
     * @return
     */
    int findTotalUserNum();
}
