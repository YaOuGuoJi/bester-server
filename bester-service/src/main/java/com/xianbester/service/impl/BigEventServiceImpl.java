package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.BigEventDTO;
import com.xianbester.api.service.BigEventService;
import com.xianbester.service.dao.BigEventDao;
import com.xianbester.service.entity.BigEventEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public BigEventDTO getBigEvent(Integer eventId) {
        BigEventEntity bigEventEntity = bigEventDao.getBigEventEntity(eventId);
        return getBigEventDTO(bigEventEntity);
    }

    @Override
    public List<BigEventDTO> findNotFinishedEvent(Integer finish) {
        List<BigEventEntity> notFinishedEvent = bigEventDao.findNotFinishedEvent(finish);
        return getBigEventDTOList(notFinishedEvent);
    }

    @Override
    public List<BigEventDTO> findEventListInMonth(Date start, Date end) {
        List<BigEventEntity> eventList = bigEventDao.findEventListInMonth(start, end);
        if (CollectionUtils.isEmpty(eventList)) {
            eventList = new ArrayList<>();
        }
        List<BigEventEntity> eventInEndPoint = bigEventDao.findEventInEndPoint(end);
        if (CollectionUtils.isEmpty(eventInEndPoint)) {
            eventInEndPoint = new ArrayList<>();
        }
        eventList.addAll(eventInEndPoint);
        return getBigEventDTOList(eventList);
    }

    @Override
    public Integer countEventInMonth(Date start, Date end) {
        List<BigEventDTO> eventListInMonth = findEventListInMonth(start, end);
        if (CollectionUtils.isEmpty(eventListInMonth)) {
            return 0;
        }
        return eventListInMonth.size();
    }

    @Override
    public Integer updateByUniqueField(String fieldName, Object fieldValue, Integer eventId) {
        return bigEventDao.updateByUniqueField(fieldName, fieldValue, eventId);
    }

    private BigEventDTO getBigEventDTO(BigEventEntity bigEventEntity) {
        if (bigEventEntity == null) {
            return null;
        }
        BigEventDTO bigEventDTO = new BigEventDTO();
        BeanUtils.copyProperties(bigEventEntity, bigEventDTO);
        return bigEventDTO;
    }

    private List<BigEventDTO> getBigEventDTOList(List<BigEventEntity> bigEventEntityList) {
        if (CollectionUtils.isEmpty(bigEventEntityList)) {
            return null;
        }
        return BeansListUtils.copyListProperties(bigEventEntityList, BigEventDTO.class);
    }

}
