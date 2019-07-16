package com.xianbester.service.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangqiang
 * @date 2019-07-16
 */
@Data
public class ChainUserinfo {

    private String id;

    private String username;

    private String password;

    private String avatar;

    private String email;

    private String mode;

    private Date addTime;

    private Date updateTime;

}
