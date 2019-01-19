package com.xianbester.service.dao;

import com.xianbester.service.entity.BigEventEntity;
import org.apache.ibatis.annotations.Param;

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

}
