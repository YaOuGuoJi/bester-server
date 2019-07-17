package com.xianbester.service.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangqiang
 * @date 2019-07-16
 */
@Data
public class ChainUserLoginRecordEntity {

    private String id;

    private String username;

    private String follow;

    private Date addTime;

    private Date updateTime;

}
