package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.BigEventDTO;
import com.xianbester.api.service.BigEventService;
import com.xianbester.service.dao.BigEventDao;
import com.xianbester.service.dao.RecordMapper;
import com.xianbester.service.entity.BigEventEntity;
import com.xianbester.service.entity.CountEntity;
import org.joda.time.DateTime;
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

    @Resource
    private RecordMapper recordMapper;

    @Override
    public BigEventDTO getBigEvent(Integer eventId) {
        BigEventEntity bigEventEntity = bigEventDao.getBigEventEntity(eventId);
        return getBigEventDTO(bigEventEntity);
    }

    @Override
    public Integer getOfflinePeopleNum(Integer eventId) {
        BigEventEntity bigEventEntity = bigEventDao.getBigEventEntity(eventId);
        if (bigEventEntity == null) {
            return 0;
        }
        Integer areaId = bigEventEntity.getAreaId();
        String eventTime = bigEventEntity.getEventTime();
        String[] times = eventTime.split(",");
        String start = times[0];
        String end = times[1];
        CountEntity countEntity = recordMapper.queryParticipantByTime(areaId, start, end);
        if (countEntity == null) {
            return 0;
        }
        return countEntity.getResult() + countEntity.getId();
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
