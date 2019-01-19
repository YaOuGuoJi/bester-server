package com.xianbester.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangqiang
 * @date 2019-01-19
 */
@Data
public class BigEventDTO implements Serializable {

    private static final long serialVersionUID = -758772512925399364L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 活动时间（格式为:yyyy/MM/dd-yyyy/MM/dd)
     */
    private String eventTime;

    /**
     * 活动地点
     */
    private String location;

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
     * 参与活动的新用户人数
     */
    private Integer newApply;

    /**
     * 区域ID
     */
    private Integer areaId;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
