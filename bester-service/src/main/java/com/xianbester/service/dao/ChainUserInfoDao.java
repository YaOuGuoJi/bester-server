package com.xianbester.service.dao;

import com.xianbester.service.entity.ChainUserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangqiang
 * @date 2019-07-16
 */

public interface ChainUserInfoDao {

    ChainUserInfo findUserInfoById(@Param("id") String id);

    ChainUserInfo findUserInfoByUsername(@Param("username") String username);

    int addUser(@Param("entity") ChainUserInfo entity);

    int updateUserInfoById(@Param("entity") ChainUserInfo entity);

}
