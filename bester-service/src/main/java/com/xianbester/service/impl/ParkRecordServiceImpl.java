package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.ParkRecordDTO;
import com.xianbester.api.service.ParkRecordService;
import com.xianbester.service.dao.CarMapper;
import com.xianbester.service.dao.ParkRecordMapper;
import com.xianbester.service.entity.CarEntity;
import com.xianbester.service.entity.ParkRecordEntity;
import com.xianbester.service.util.BeansListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
@Component
public class ParkRecordServiceImpl implements ParkRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParkRecordService.class);
    @Resource
    private ParkRecordMapper parkRecordMapper;
    @Resource
    private CarMapper carMapper;

    @Override
    public int addParkRecordDTO(ParkRecordDTO parkRecordDTO) {
        ParkRecordEntity parkRecordEntity = new ParkRecordEntity();
        BeanUtils.copyProperties(parkRecordDTO, parkRecordEntity);
        parkRecordEntity.setCarId(carFactoryByLicense(parkRecordDTO.getLicense()));
        return parkRecordMapper.addParkRecord(parkRecordEntity);
    }

    @Override
    public int deleteParkRecordDTO(int id) {
        return parkRecordMapper.deleteParkRecord(id);
    }

    @Override
    public ParkRecordDTO selectParkRecordDROById(int id) {
        ParkRecordEntity parkRecordEntity = parkRecordMapper.selectParkRecordById(id);
        if (parkRecordEntity == null) {
            return null;
        }
        CarEntity carEntity = carMapper.selectCarById(parkRecordEntity.getCarId());
        if (carEntity == null || StringUtils.isEmpty(carEntity.getLicense())) {
            LOGGER.error("找不到对应的车牌号！recordId:[{}]", id);
            return null;
        }
        ParkRecordDTO parkRecordDTO = new ParkRecordDTO();
        BeanUtils.copyProperties(parkRecordEntity, parkRecordDTO);
        parkRecordDTO.setLicense(carEntity.getLicense());
        return parkRecordDTO;
    }

    @Override
    public List<ParkRecordDTO> selectParkRecordDTOByLicense(String license) {
        CarEntity carEntity = carMapper.selectCarByLicense(license);
        if (carEntity == null) {
            return Collections.emptyList();
        }
        List<ParkRecordEntity> parkRecordEntities = parkRecordMapper.selectParkRecordByCarId(carEntity.getId());
        if (CollectionUtils.isEmpty(parkRecordEntities)) {
            return Collections.emptyList();
        }
        List<ParkRecordDTO> parkRecordDTOs = BeansListUtils.copyListProperties(parkRecordEntities, ParkRecordDTO.class);
        parkRecordDTOs.forEach(parkRecordDTO -> parkRecordDTO.setLicense(license));
        return parkRecordDTOs;
    }

    @Override
    public int selectNowCarNum() {
        List<Integer> integers = parkRecordMapper.selectNowCarNum();
        return Math.abs(integers.get(0) - integers.get(1));
    }

    /**
     * 新增停车记录时车，根据车牌查车,若无车则增车
     *
     * @param license
     * @return
     */
    private int carFactoryByLicense(String license) {
        CarEntity carEntity = carMapper.selectCarByLicense(license);
        if (carEntity != null) {
            return carEntity.getId();
        }
        carEntity = new CarEntity();
        carEntity.setOwnerId(0);
        carEntity.setLicense(license);
        carMapper.addCar(carEntity);
        return carEntity.getId();
    }
}
