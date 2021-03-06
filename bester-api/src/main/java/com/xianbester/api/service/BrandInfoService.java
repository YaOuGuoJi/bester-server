package com.xianbester.api.service;

import com.xianbester.api.dto.BrandInfoDTO;

import java.util.List;

/**
 * @author yanrui
 */
public interface BrandInfoService {

    /**
     * 按条件动态查询所有品牌池
     *
     * @param brandName
     * @param type
     * @param floor
     * @return
     */
    List<BrandInfoDTO> selectBrandInfo(String brandName, Integer type, Integer floor);

    /**
     * 根据品牌id查询品牌信息
     *
     * @param brandId
     * @return
     */
    BrandInfoDTO selectBrandById(Integer brandId);

    /**
     * 修改点赞数与收藏数
     *
     * @param brandId
     * @param type
     * @param number
     * @return
     * @see com.xianbester.api.constant.BrandActionType
     */
    int updatePraiseOrCollectNum(Integer brandId, Integer type, Integer number);

    List<BrandInfoDTO> selectByIdList(List<Integer> brandIdList);

}
