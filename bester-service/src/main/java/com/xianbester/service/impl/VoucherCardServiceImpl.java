package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.xianbester.api.dto.VoucherCardDTO;
import com.xianbester.api.service.VoucherCardService;
import com.xianbester.service.dao.VoucherCardDao;
import com.xianbester.service.entity.VoucherCardEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuwen
 * @date 2018/12/13
 */
@Service
@Component
public class VoucherCardServiceImpl implements VoucherCardService {

    @Resource
    private VoucherCardDao voucherCardDao;

    @Override
    public VoucherCardDTO findVoucherCardById(String cardId) {
        VoucherCardEntity entity = voucherCardDao.findCardByCardId(cardId);
        if (entity == null) {
            return null;
        }
        VoucherCardDTO voucherCardDTO = new VoucherCardDTO();
        BeanUtils.copyProperties(entity, voucherCardDTO);
        return voucherCardDTO;
    }

    @Override
    public int bindVoucherCard2User(String cardId, int userId) {
        return voucherCardDao.bindCard2User(cardId, userId);
    }

    @Override
    public List<VoucherCardDTO> findUserBindVouchers(int userId) {
        List<VoucherCardEntity> userBindCards = voucherCardDao.findUserBindCards(userId);
        if (CollectionUtils.isEmpty(userBindCards)) {
            return Lists.newArrayList();
        }
        return BeansListUtils.copyListProperties(userBindCards, VoucherCardDTO.class);
    }
}
