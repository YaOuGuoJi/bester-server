package com.xianbester.service.dao;

import com.xianbester.service.entity.ShopAccountEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuwen
 * @date 2018/12/4
 */
public interface ShopAccountMapper {

    /**
     * 根据商户id查询
     *
     * @param phoneNum
     * @return
     */
    ShopAccountEntity findByShopId(@Param("phoneNum") String phoneNum);

    /**
     * 添加
     *
     * @param shopAccountEntity
     * @return
     */
    Integer addShopAccount(@Param("shopAccountEntity") ShopAccountEntity shopAccountEntity);
}
