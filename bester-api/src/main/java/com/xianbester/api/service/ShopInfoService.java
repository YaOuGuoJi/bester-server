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
}
