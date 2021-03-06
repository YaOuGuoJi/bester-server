package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.AreaDTO;
import com.xianbester.api.service.AreaService;
import com.xianbester.service.dao.AreaMapper;
import com.xianbester.service.entity.AreaEntity;
import com.xianbester.service.util.BeansListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
@Component
public class AreaServiceImpl implements AreaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaServiceImpl.class);

    @Resource
    private AreaMapper areaMapper;

    @Override
    public List<AreaDTO> selectAll() {
        List<AreaEntity> entityList = areaMapper.selectAll();
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.emptyList();
        }
        return BeansListUtils.copyListProperties(entityList, AreaDTO.class);
    }

    @Override
    public void deleteByPrimaryKey(Integer areaId) {
        if (areaId == 0) {
            return;
        }
        areaMapper.deleteByPrimaryKey(areaId);
        LOGGER.info("id为[{}]的分区信息已删除", areaId);
    }

    @Override
    public int insert(AreaDTO record) {
        if (record == null) {
            return 0;
        }
        AreaEntity area = new AreaEntity();
        area.setAName(record.getAName());
        area.setASort(record.getASort());
        area.setAAddress(record.getAAddress());

        areaMapper.insert(area);
        return area.getAreaId();
    }

    @Override
    public AreaDTO selectByPrimaryKey(Integer areaId) {
        AreaEntity area = areaMapper.selectByPrimaryKey(areaId);
        if (area == null) {
            return null;
        }
        AreaDTO areaDTO = new AreaDTO();
        BeanUtils.copyProperties(area, areaDTO);
        return areaDTO;
    }

    @Override
    public int updateByPrimaryKeySelective(AreaDTO record) {
        if (record == null) {
            return 0;
        }
        AreaEntity area = new AreaEntity();
        BeanUtils.copyProperties(record, area);
        return areaMapper.updateByPrimaryKeySelective(area);
    }

}
