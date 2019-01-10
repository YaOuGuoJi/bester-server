package com.xianbester.service.dao;

import com.xianbester.service.entity.ShopInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author liuwen
 * @date 2018/12/29
 */
public interface ShopInfoDao {

    /**
     * 批量查询
     *
     * @param shopIds
     * @return
     */
    List<ShopInfoEntity> batchSelect(@Param("shopIds") Collection<Integer> shopIds);

    /**
     * 增
     *
     * @param shopInfoEntity
     * @return
     */
    void addShopInfo(@Param("shopInfoEntity") ShopInfoEntity shopInfoEntity);

    /**
     * 软删除
     *
     * @param shopId
     * @return
     */
    int deleteShopInfo(@Param("shopId") int shopId);

    /**
     * 改
     *
     * @param shopInfoEntity
     * @return
     */
    int updateShopInfo(@Param("shopInfoEntity") ShopInfoEntity shopInfoEntity);

    /**
     * 查询
     *
     * @param shopId
     * @return
     */
    ShopInfoEntity findShopInfoById(@Param("shopId") int shopId);

    /**
     * 根据商户电话查询商户
     *
     * @param phoneNo
     * @return
     */
    ShopInfoEntity findShopInfoByPhone(@Param("phoneNo")String phoneNo);
}
