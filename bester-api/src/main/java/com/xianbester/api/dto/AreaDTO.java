package com.xianbester.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuwen
 */
@Data
public class AreaDTO implements Serializable {

    private static final long serialVersionUID = -829433840843387396L;

    /**
     * 分区主键id
     */
    private Integer areaId;

    /**
     * 分区名称
     */
    private String aName;

    /**
     * 分区
     */
    private String aSort;

    /**
     * 添加时间
     */
    private Date aAddTime;

    /**
     * 更改时间
     */
    private Date aUpdateTime;

    /**
     * 分区地址
     */
    private String aAddress;

}
