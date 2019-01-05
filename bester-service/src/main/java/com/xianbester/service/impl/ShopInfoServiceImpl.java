package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.ShopInfoDTO;
import com.xianbester.api.service.ShopInfoService;
import com.xianbester.service.dao.ShopInfoDao;
import com.xianbester.service.entity.ShopInfoEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuwen
 * @date 2018/12/29
 */
@Service
@Component
public class ShopInfoServiceImpl implements ShopInfoService {

    @Resource
    private ShopInfoDao shopInfoDao;

    @Override
    public Map<Integer, ShopInfoDTO> batchFindByShopIds(Collection<Integer> shopIds) {
        if (CollectionUtils.isEmpty(shopIds)) {
            return Collections.emptyMap();
        }
        List<ShopInfoEntity> entityList = shopInfoDao.batchSelect(shopIds);
        List<ShopInfoDTO> shopInfoDTOList = BeansListUtils.copyListProperties(entityList, ShopInfoDTO.class);
        return shopInfoDTOList.stream().collect(Collectors.toMap(ShopInfoDTO::getShopId, shopInfoDTO -> shopInfoDTO));
    }
}
