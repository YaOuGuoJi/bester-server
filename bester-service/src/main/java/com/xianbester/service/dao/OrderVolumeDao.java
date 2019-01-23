package com.xianbester.service.dao;

import com.xianbester.service.entity.CountEntity;
import com.xianbester.service.entity.OrderVolumeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 * @date 2019-01-22
 */
public interface OrderVolumeDao {
    /**
     * 按区域查询订单完成量
     *
     * @param start
     * @param end
     * @return
     */
    List<OrderVolumeEntity> queryOrderByArea(@Param("startTime") Date start, @Param("endTime") Date end);

    /**
     * 按楼查询订单完成量
     *
     * @param start
     * @param end
     * @return
     */
    List<CountEntity> queryOrderByBuilding(@Param("startTime") Date start, @Param("endTime") Date end);

    /**
     * 按层查询订单完成量
     *
     * @param start
     * @param end
     * @param building
     * @return
     */
    List<CountEntity> queryOrderByFloors(@Param("startTime") Date start, @Param("endTime") Date end, @Param("building") Integer building);

}
