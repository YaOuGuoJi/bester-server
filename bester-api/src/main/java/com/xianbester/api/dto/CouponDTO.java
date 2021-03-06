package com.xianbester.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 优惠券DTO
 *
 * @author zhangqiang
 * @date 2018-12-17
 */
@Data
public class CouponDTO implements Serializable {

    private static final long serialVersionUID = -7343570557876426826L;
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 商户ID
     */
    private List<String> shopId;

    /**
     * 优惠券图片
     */
    private String imageUrl;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 优惠券余量
     */
    private Integer margin;

    /**
     * 优惠形式（1：指定XX现金，2：折扣）
     */
    private Integer couponType;

    /**
     * 优惠现金
     */
    private BigDecimal offerCash;

    /**
     * 优惠折扣
     */
    private BigDecimal offerDiscount;

    /**
     * 使用门槛（满XX元可用，为零则代表使用条件为无限制）
     */
    private BigDecimal threshold;

    /**
     * 可领取的会员等级
     */
    private Integer vipLevel;

    /**
     * 每人限领
     */
    private Integer limitNum;

    /**
     * 有效期（天数）
     */
    private Integer validityPeriod;

    /**
     * 可用商品（指定一个或者多个)
     */
    private List<String> available;

    /**
     * 使用说明
     */
    private String description;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
