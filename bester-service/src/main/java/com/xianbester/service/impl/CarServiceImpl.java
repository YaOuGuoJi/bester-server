package com.xianbester.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xianbester.api.dto.CarDTO;
import com.xianbester.api.service.CarService;
import com.xianbester.service.dao.CarMapper;
import com.xianbester.service.entity.CarEntity;
import com.xianbester.service.util.BeansListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;

    @Override
    public int addCarDTO(CarDTO carDTO) {
        if (existLicense(carDTO.getLicense())) {
            return 0;
        }
        CarEntity carEntity = new CarEntity();
        BeanUtils.copyProperties(carDTO, carEntity);
        return carMapper.addCar(carEntity);
    }

    @Override
    public int updateCarDTO(CarDTO carDTO) {
        if (existLicense(carDTO.getLicense())) {
            return 0;
        }
        CarEntity carEntity = new CarEntity();
        BeanUtils.copyProperties(carDTO, carEntity);
        return carMapper.updateCar(carEntity);
    }

    @Override
    public int deleteCarDTO(int id) {
        return carMapper.deleteCar(id);
    }

    @Override
    public CarDTO selectCarDTOById(int id) {
        CarEntity carEntity = carMapper.selectCarById(id);
        if (carEntity == null) {
            return null;
        }
        CarDTO carDTO = new CarDTO();
        BeanUtils.copyProperties(carEntity, carDTO);
        return carDTO;
    }

    @Override
    public CarDTO selectCarDTOByLicense(String license) {
        CarEntity carEntity = carMapper.selectCarByLicense(license);
        if (carEntity == null) {
            return null;
        }
        CarDTO carDTO = new CarDTO();
        BeanUtils.copyProperties(carEntity, carDTO);
        return carDTO;
    }

    @Override
    public List<CarDTO> selectAll() {
        List<CarEntity> carEntities = carMapper.selectAll();
        if (CollectionUtils.isEmpty(carEntities)) {
            return BeansListUtils.copyListProperties(carEntities, CarDTO.class);
        }
        return new ArrayList<>();
    }

    private boolean existLicense(String license) {
        return StringUtils.isEmpty(license) || carMapper.selectCarByLicense(license) != null;
    }
}
