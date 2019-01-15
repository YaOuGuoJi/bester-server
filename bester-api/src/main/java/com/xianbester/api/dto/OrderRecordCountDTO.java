package com.xianbester.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author liang
 */
@Data
public class OrderRecordCountDTO implements Serializable {
    private static final long serialVersionUID = -7238780244745508896L;
    private BigDecimal price;
    private BigDecimal frequency;
    private BigDecimal peopleNum;
    private BigDecimal averagePrice;
}
