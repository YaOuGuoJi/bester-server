package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.BigEventDTO;
import com.xianbester.api.service.BigEventService;
import com.xianbester.service.dao.BigEventDao;
import com.xianbester.service.entity.BigEventEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangqiang
 * @date 2019-01-19
 */

@Service
@Component
public class BigEventServiceImpl implements BigEventService {

    @Resource
    private BigEventDao bigEventDao;

    @Override
    public BigEventDTO getBigEventEntity(Integer eventId) {
        BigEventEntity bigEventEntity = bigEventDao.getBigEventEntity(eventId);
        return getBigEventDTO(bigEventEntity);
    }

    private BigEventDTO getBigEventDTO(BigEventEntity bigEventEntity) {
        if (bigEventEntity == null) {
            return null;
        }
        BigEventDTO bigEventDTO = new BigEventDTO();
        BeanUtils.copyProperties(bigEventEntity, bigEventDTO);
        return bigEventDTO;
    }

}
