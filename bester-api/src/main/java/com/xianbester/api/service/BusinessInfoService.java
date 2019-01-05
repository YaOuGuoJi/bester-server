package com.xianbester.api.service;

import com.xianbester.api.dto.BusinessInfoDTO;

/**
 * @author yanrui
 */
public interface BusinessInfoService{

    /**
     * 插入招商信息
     *
     * @param businessInfoDTO
     * @return
     */
    Integer insertBusinessInfo(BusinessInfoDTO businessInfoDTO);
}
