package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.ShopInfoDTO;
import com.xianbester.api.service.ShopInfoService;
import com.xianbester.service.dao.ShopInfoDao;
import com.xianbester.service.entity.ShopInfoEntity;
import com.xianbester.service.util.BeansListUtils;
import com.xianbester.service.util.UuidUtil;
import org.springframework.beans.BeanUtils;
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

    @Override
    public ShopInfoDTO findShopInfoByShopId(int shopId) {
        ShopInfoEntity entity = shopInfoDao.findShopInfoById(shopId);
        if (entity == null) {
            return null;
        }
        ShopInfoDTO shopInfoDTO = new ShopInfoDTO();
        BeanUtils.copyProperties(entity, shopInfoDTO);
        return shopInfoDTO;
    }

    @Override
    public ShopInfoDTO findShopInfoByPhone(String phoneNo) {
        ShopInfoEntity shopInfoEntity = shopInfoDao.findShopInfoByPhone(phoneNo);
        if (shopInfoEntity == null) {
            return null;
        }
        ShopInfoDTO shopInfoDTO = new ShopInfoDTO();
        BeanUtils.copyProperties(shopInfoEntity, shopInfoDTO);
        return shopInfoDTO;
    }

    @Override
    public int insertShopInfo(ShopInfoDTO shopInfoDTO) {
        if (shopInfoDTO == null) {
            return 0;
        }
        shopInfoDTO.setShopId(0);
        shopInfoDTO.setShopUuid(UuidUtil.buildUuid());
        ShopInfoEntity shopInfoEntity = new ShopInfoEntity();
        BeanUtils.copyProperties(shopInfoDTO, shopInfoEntity);
        shopInfoDao.addShopInfo(shopInfoEntity);
        return shopInfoEntity.getShopId();
    }

    @Override
    public int updateShopInfoById(ShopInfoDTO shopInfoDTO) {
        if (shopInfoDTO == null || shopInfoDTO.getShopId() <= 0) {
            return 0;
        }
        ShopInfoEntity shopInfoEntity = new ShopInfoEntity();
        BeanUtils.copyProperties(shopInfoDTO, shopInfoEntity);
        return shopInfoDao.updateShopInfo(shopInfoEntity);
    }

    @Override
    public int deleteShopInfoByShopId(int shopId) {
        if (shopId <= 0) {
            return 0;
        }
        return shopInfoDao.deleteShopInfo(shopId);
    }
}
