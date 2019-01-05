package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.BlackGoldCardDTO;
import com.xianbester.api.service.BlackGoldCardService;
import com.xianbester.service.dao.BlackGoldCardDao;
import com.xianbester.service.entity.BlackGoldCardEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liuwen
 * @date 2018/12/11
 */
@Service
@Component
public class BlackGoldCardServiceImpl implements BlackGoldCardService {

    @Resource
    private BlackGoldCardDao blackGoldCardDao;

    @Override
    public BlackGoldCardDTO findBlackGoldCardByCardId(String cardId) {
        BlackGoldCardEntity entity = blackGoldCardDao.findCardByCardId(cardId);
        return getBlackGoldCardDTO(entity);
    }

    @Override
    public int bindCardToUser(String cardId, int userId) {
        return blackGoldCardDao.bindCard2User(cardId, userId);
    }

    @Override
    public BlackGoldCardDTO findBlackGoldCardInfoByUserId(int userId) {
        BlackGoldCardEntity blackGoldCardEntity = blackGoldCardDao.findCardInfoByUserId(userId);
        return getBlackGoldCardDTO(blackGoldCardEntity);
    }

    private BlackGoldCardDTO getBlackGoldCardDTO(BlackGoldCardEntity blackGoldCardEntity) {
        if (blackGoldCardEntity == null) {
            return null;
        }
        BlackGoldCardDTO blackGoldCardDTO = new BlackGoldCardDTO();
        BeanUtils.copyProperties(blackGoldCardEntity, blackGoldCardDTO);
        return blackGoldCardDTO;
    }
}
