package com.xianbester.service.task;

import com.xianbester.api.constant.BlockChainParameters;
import com.xianbester.service.dao.PowerRecordDao;
import com.xianbester.service.util.TemporaryPowerUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yanrui
 */
@Component
public class UpdateInvalidPowerTask {

    @Resource
    private PowerRecordDao powerRecordDao;

    @Scheduled(cron = BlockChainParameters.TOTAL_ORE_INTERVAL)
   public void updateInvalidPower(){
        powerRecordDao.updateTemporaryPower(TemporaryPowerUtil.expiredPowerTime());
   }

}
