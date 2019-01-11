package com.xianbester.api.service;

import com.xianbester.api.dto.ShopInfoDTO;

import java.util.Collection;
import java.util.Map;

/**
 * @author liuwen
 * @date 2018/12/29
 */
public interface ShopInfoService {

    /**
     * 根据商户id批量查询
     *
     * @param shopIds
     * @return
     */
    Map<Integer, ShopInfoDTO> batchFindByShopIds(Collection<Integer> shopIds);

    /**
     * 根据shopId查询商户详细信息
     *
     * @param shopId
     * @return
     */
    ShopInfoDTO findShopInfoByShopId(int shopId);

    /**
     * 根据用户电话查询用户信息
     *
     * @param phoneNo
     * @return
     */
    ShopInfoDTO findShopInfoByPhone(String phoneNo);

    /**
     * 插入商户详细信息
     *
     * @param shopInfoDTO
     * @return
     */
    int insertShopInfo(ShopInfoDTO shopInfoDTO);

    /**
     * 更新商户信息
     *
     * @param shopInfoDTO
     * @return
     */
    int updateShopInfoById(ShopInfoDTO shopInfoDTO);

    /**
     * 根据商户id删除商户信息
     *
     * @param shopId
     * @return
     */
    int deleteShopInfoByShopId(int shopId);
}
