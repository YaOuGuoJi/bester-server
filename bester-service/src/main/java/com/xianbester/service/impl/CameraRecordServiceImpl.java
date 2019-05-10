package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Maps;
import com.xianbester.api.dto.CameraRecordDTO;
import com.xianbester.api.service.CameraRecordService;
import com.xianbester.service.dao.CameraMapper;
import com.xianbester.service.dao.RecordMapper;
import com.xianbester.service.entity.CameraRecordEntity;
import com.xianbester.service.entity.CountEntity;
import com.xianbester.service.util.BeansListUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Component
public class CameraRecordServiceImpl implements CameraRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CameraRecordServiceImpl.class);

    @Resource
    private CameraMapper cameraMapper;

    @Resource
    private RecordMapper recordMapper;

    @Override
    public List<CameraRecordDTO> batchSelectAllRecords(List<Integer> cameraIds) {
        List<CameraRecordEntity> entityList = recordMapper.batchSelectNewRecords(cameraIds);
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.emptyList();
        }
        return BeansListUtils.copyListProperties(entityList, CameraRecordDTO.class);
    }

    @Override
    public void deleteByPrimaryKey(Integer cRecodeId) {
        if (cRecodeId == 0) {
            return;
        }
        recordMapper.deleteByPrimaryKey(cRecodeId);
        LOGGER.info("id为[{}]的摄像头记录已删除", cRecodeId);
    }

    @Override
    public int insert(CameraRecordDTO record) {
        if (record == null) {
            return 0;
        }
        CameraRecordEntity recordEntity = new CameraRecordEntity();
        recordEntity.setCameraId(recordEntity.getCameraId());
        recordEntity.setCrMaleNumber(recordEntity.getCrMaleNumber());
        recordEntity.setCrFemaleNumber(recordEntity.getCrFemaleNumber());
        recordEntity.setCrAddTime(recordEntity.getCrAddTime());
        recordEntity.setCrUpdateTime(recordEntity.getCrUpdateTime());
        recordMapper.insert(recordEntity);
        return recordEntity.getCameraId();
    }

    @Override
    public CameraRecordDTO selectByPrimaryKey(Integer cRecodeId) {
        CameraRecordDTO cameraRecordDTO = new CameraRecordDTO();
        CameraRecordEntity cameraRecordEntity = recordMapper.selectByPrimaryKey(cRecodeId);
        if (cameraRecordEntity != null) {
            BeanUtils.copyProperties(cameraRecordEntity, cameraRecordDTO);
        }
        return cameraRecordDTO;
    }

    @Override
    public int updateByPrimaryKeySelective(CameraRecordDTO record) {
        if (record == null) {
            return 0;
        }
        CameraRecordEntity recordEntity = new CameraRecordEntity();
        BeanUtils.copyProperties(record, recordEntity);
        return recordMapper.updateByPrimaryKeySelective(recordEntity);
    }

    @Override
    public Map<String, Integer> queryVisitorsByTime(int days) {
        Date startTime = days == 1 ? new DateTime().withTimeAtStartOfDay().toDate() : new DateTime().minusDays(days).toDate();
        Date endTime = new Date();
        CountEntity countEntity = recordMapper.queryVisitorsByTime(startTime, endTime);
        if (countEntity == null) {
            return Collections.emptyMap();
        }
        Map<String, Integer> stringIntegerMap = Maps.newHashMap();
        stringIntegerMap.put("man", countEntity.getId());
        stringIntegerMap.put("female", countEntity.getResult());
        return stringIntegerMap;
    }

    @Override
    public Integer queryParticipantByTime(List<String> locationIdList, Date start, Date end) {
        List<Integer> cameraIdList = cameraMapper.findCameraIdListByLocationIds(locationIdList);
        if (CollectionUtils.isEmpty(cameraIdList)) {
            return 0;
        }
        CountEntity countEntity = recordMapper.checkNumberOfParticipantsInterval(cameraIdList, start, end);
        if (countEntity == null) {
            return 0;
        }
        Integer maleNum = countEntity.getId();
        Integer femaleNum = countEntity.getResult();
        return ((maleNum == null ? 0 : maleNum) + (femaleNum == null ? 0 : femaleNum));
    }

}
