package com.xianbester.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lizhi
 */
@Data
public class CountDTO implements Serializable {

    private static final long serialVersionUID = 5400508602266648426L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 结果
     */
    private Integer result;
}

