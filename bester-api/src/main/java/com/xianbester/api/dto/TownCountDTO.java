package com.xianbester.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class TownCountDTO implements Serializable {
    private static final long serialVersionUID = 6748619651598191623L;
    private Integer countNum;
    private Integer building;
    private Integer floors;
    private String areaName;
}
