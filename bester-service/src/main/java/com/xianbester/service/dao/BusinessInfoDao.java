package com.xianbester.service.dao;

import com.xianbester.service.entity.BusinessInfoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author yanrui
 */
public interface BusinessInfoDao {

    int insertBusinessInfo(@Param("businessInfo") BusinessInfoEntity businessInfoEntity);
}
