package com.xianbester.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lizhi
 */
@Data
public class OrderVolumeDTO implements Serializable {

    private static final long serialVersionUID = 4766478160737489544L;

    /**
     * 名称
     */
    private String name;

    /**
     * 数量
     */
    private Integer nums;
}
