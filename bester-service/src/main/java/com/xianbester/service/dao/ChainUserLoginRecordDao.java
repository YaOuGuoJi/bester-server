package com.xianbester.service.dao;

import com.xianbester.service.entity.ChainUserLoginRecordEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangqiang
 * @date 2019-07-16
 */

public interface ChainUserLoginRecordDao {

    int addUserLoginRecord(@Param("entity") ChainUserLoginRecordEntity entity);

}
