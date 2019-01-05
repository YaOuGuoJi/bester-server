package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianbester.api.constant.OreRecordStatus;
import com.xianbester.api.dto.OreRecordDTO;
import com.xianbester.api.service.OreRecordService;
import com.xianbester.service.dao.OreRecordDao;
import com.xianbester.service.entity.OreRecordEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwen
 * @date 2018/11/2
 */
@Service
@Component
public class OreRecordServiceImpl implements OreRecordService {
    @Resource
    private OreRecordDao oreRecordDao;

    @Override
    public BigDecimal queryOreNumbByUserId(Integer userId) {
        return oreRecordDao.queryOreNumbByUserId(userId);
    }

    @Override
    public PageInfo<OreRecordDTO> queryOreRecordByUserId(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OreRecordEntity> oreRecordEntities = oreRecordDao.queryAllOreRecordByUserId(userId, OreRecordStatus.RECEIVED);
        return BeansListUtils.copyListPageInfo(oreRecordEntities, OreRecordDTO.class);
    }

    @Override
    public Integer receiveOre(Integer id) {
        return oreRecordDao.receiveOre(id);
    }

    @Override
    public OreRecordDTO showOreById(Integer id) {
        OreRecordEntity oreRecordEntity = oreRecordDao.showOreById(id);
        if (oreRecordEntity == null) {
            return null;
        }
        OreRecordDTO oreRecordDTO = new OreRecordDTO();
        BeanUtils.copyProperties(oreRecordEntity, oreRecordDTO);
        return oreRecordDTO;
    }

    @Override
    public List<OreRecordDTO> showOreByUserId(Integer userId) {
        List<OreRecordEntity> oreRecordEntities = oreRecordDao.queryAllOreRecordByUserId(userId, OreRecordStatus.PENDING);
        if (CollectionUtils.isEmpty(oreRecordEntities)) {
            return new ArrayList<>();
        }
        return BeansListUtils.copyListProperties(oreRecordEntities, OreRecordDTO.class);
    }
}
