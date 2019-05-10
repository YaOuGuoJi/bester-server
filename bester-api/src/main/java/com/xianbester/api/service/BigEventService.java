package com.xianbester.api.service;

import com.xianbester.api.dto.BigEventDTO;

import java.util.Date;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-01-19
 */

public interface BigEventService {

    /**
     * 根据ID查询活动详情
     *
     * @param eventId
     * @return
     */
    BigEventDTO getBigEvent(Integer eventId);

    /**
     * 查找现在未结束的活动
     *
     * @return
     */
    List<BigEventDTO> findNotFinishedEvent(Integer finish);

    /**
     * 根据字段名和ID更新字段值
     *
     * @param fieldName
     * @param fieldValue
     * @param eventId
     * @return
     */
    Integer updateByUniqueField(String fieldName, Object fieldValue, Integer eventId);

    /**
     * 查询一段时间内的活动
     *
     * @param start
     * @param end
     * @return
     */
    List<BigEventDTO> findEventListInMonth(Date start, Date end);

    /**
     * 查询一月内发布的活动数
     *
     * @param start
     * @param end
     * @return
     */
    Integer countEventInMonth(Date start, Date end);


}
