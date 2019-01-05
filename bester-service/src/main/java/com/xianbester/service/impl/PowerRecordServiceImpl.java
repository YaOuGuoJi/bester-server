package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xianbester.api.constant.PowerStatus;
import com.xianbester.api.dto.PowerRecordDTO;
import com.xianbester.api.service.PowerRecordService;
import com.xianbester.service.dao.PowerRecordDao;
import com.xianbester.service.entity.PowerEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author liuwen
 * @date 2018/11/2
 */
@Service
@Component
public class PowerRecordServiceImpl implements PowerRecordService {

    @Resource
    private PowerRecordDao powerRecordDao;

    @Override
    public PageInfo<PowerRecordDTO> pageFindUserValidPower(int userId, int pageNum, int pageSize) {
        Assert.isTrue(userId > 0 && pageSize > 0 && pageNum > 0, "参数错误");
        PageHelper.startPage(pageNum, pageSize, true);
        List<PowerEntity> powerEntities = powerRecordDao.selectUserValidPower(userId);
        return BeansListUtils.copyListPageInfo(powerEntities, PowerRecordDTO.class);
    }

    @Override
    public PageInfo<PowerRecordDTO> pageFindUserExpiredPower(int userId, int pageNum, int pageSize) {
        Assert.isTrue(userId > 0 && pageSize > 0 && pageNum > 0, "参数错误");
        PageHelper.startPage(pageNum, pageSize, true);
        List<PowerEntity> powerEntities = powerRecordDao.selectUserExpiredPower(userId);
        return BeansListUtils.copyListPageInfo(powerEntities, PowerRecordDTO.class);
    }

    @Override
    public Integer findValidPower(int userId, int valid) {
        Assert.isTrue(userId > 0, "参数错误");
        return powerRecordDao.findValidPower(userId, valid);
    }

    @Override
    public int addUserPower(int userId, String source, int power, int isTemporary) {
        PowerEntity powerEntity = new PowerEntity();
        powerEntity.setUserId(userId);
        powerEntity.setSource(source);
        powerEntity.setPower(power);
        powerEntity.setTemporary(isTemporary);
        powerEntity.setValid(PowerStatus.VALID);
        return powerRecordDao.addUserPower(powerEntity);
    }

    @Override
    public Date selectPowerBySource(int userId) {
        return powerRecordDao.selectPowerBySource(userId);
    }


}
