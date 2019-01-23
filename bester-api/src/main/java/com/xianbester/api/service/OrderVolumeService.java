package com.xianbester.api.service;

import com.xianbester.api.dto.CountDTO;
import com.xianbester.api.dto.OrderVolumeDTO;

import java.util.Date;
import java.util.List;

/**
 * @author lizhi
 * @date 2019-01-22
 */
public interface OrderVolumeService {
    /**
     * 按区域查询订单完成量
     *
     * @param start
     * @param end
     * @return
     */
    List<OrderVolumeDTO> queryOrderByArea(Date start, Date end);

    /**
     * 按楼查询订单完成量
     *
     * @param start
     * @param end
     * @return
     */
    List<CountDTO> queryOrderByBuilding(Date start, Date end);

    /**
     * 按层查询订单完成量
     *
     * @param start
     * @param end
     * @param building
     * @return
     */
    List<CountDTO> queryOrderByFloors(Date start, Date end, Integer building);
}
