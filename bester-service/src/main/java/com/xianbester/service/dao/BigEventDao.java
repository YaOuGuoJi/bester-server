package com.xianbester.service.dao;

import com.xianbester.service.entity.BigEventEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2019-01-19
 */

public interface BigEventDao {

    /**
     * 根据ID查询活动详情
     *
     * @param eventId
     * @return
     */
    BigEventEntity getBigEventEntity(@Param("eventId") Integer eventId);

    /**
     * 查询当前未结束的活动
     *
     * @param finish
     * @return
     */
    List<BigEventEntity> findNotFinishedEvent(Integer finish);

    /**
     * 根据字段名和ID更新字段值
     *
     * @param fieldName
     * @param fieldValue
     * @param eventId
     * @return
     */
    int updateByUniqueField(@Param("fieldName") String fieldName,
                            @Param("fieldValue") String fieldValue,
                            @Param("eventId") Integer eventId);

    /**
     * 查询一段时间内的活动
     *
     * @param start
     * @param end
     * @return
     */
    List<BigEventEntity> findEventListInMonth(@Param("start") Date start, @Param("end") Date end);

    /**
     * 查询在一段时间内已经开始但还未结束的活动
     *
     * @param endPoint
     * @return
     */
    List<BigEventEntity> findEventInEndPoint(@Param("endPoint") Date endPoint);

}
