package com.xianbester.service.dao;

import com.xianbester.service.entity.CarEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CarMapper {
    /**
     * 新增汽车
     *
     * @param car
     * @return
     */
    int addCar(@Param("car") CarEntity car);

    /**
     * 根据id修改汽车
     *
     * @param car
     * @return
     */
    int updateCar(@Param("car") CarEntity car);

    /**
     * 根据汽车id删除汽车
     *
     * @param id
     * @return
     */
    int deleteCar(@Param("id") int id);

    /**
     * 根据id查汽车
     *
     * @param id
     * @return
     */
    CarEntity selectCarById(@Param("id") int id);

    /**
     * 根据车牌查车
     *
     * @param license
     * @return
     */
    CarEntity selectCarByLicense(@Param("license") String license);

    /**
     * 查出所有的车（需要改成分页形式的）
     *
     * @return
     */
    List<CarEntity> selectAll();


}
