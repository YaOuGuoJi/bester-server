package com.xianbester.service.dao;

import com.xianbester.service.entity.ChainUserinfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangqiang
 * @date 2019-07-16
 */

public interface ChainUserInfoDao {

    ChainUserinfo findUserInfoById(@Param("id") String id);

    ChainUserinfo findUserInfoByUsername(@Param("username") String username);

    int addUser(@Param("entity") ChainUserinfo entity);

    int updateUserInfoById(@Param("entity") ChainUserinfo entity);

}
