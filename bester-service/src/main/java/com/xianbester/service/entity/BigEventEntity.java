package com.xianbester.service.entity;

import lombok.Data;

import java.util.Date;

/**
 * 大型活动Entity
 *
 * @author zhangqiang
 * @date 2019-01-19
 */
@Data
public class BigEventEntity {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 活动时间（格式为:yyyy-MM-dd HH:mm:ss,yyyy-MM-dd HH:mm:ss)
     */
    private String eventTime;

    /**
     * 活动地点(LocationID的集合，格式为1，2）
     */
    private String location;

    /**
     * 活动开始时间
     */
    private Date beginTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 活动赞助商
     */
    private String sponsor;

    /**
     * 线上报名人数
     */
    private Integer eventApplyNum;

    /**
     * 线下参加人数
     */
    private Integer eventJoinNum;

    /**
     * 活动主题
     */
    private String topic;

    /**
     * 参与活动的新用户人数
     */
    private Integer newApply;

    /**
     * 参与活动的商铺ID
     */
    private String shopIdList;

    /**
     * 是否结束（0：结束，1：未结束)
     */
    private Integer finish;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
