package com.xianbester.api.service;

import com.xianbester.api.dto.BigEventDTO;

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
     * 根据ID查询线下参与活动人数
     *
     * @param eventId
     * @return
     */
    Integer getOfflinePeopleNum(Integer eventId);

}
