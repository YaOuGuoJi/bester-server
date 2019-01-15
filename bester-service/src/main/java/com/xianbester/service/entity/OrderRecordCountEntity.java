package com.xianbester.service.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liang
 */
@Data
public class OrderRecordCountEntity {
    private BigDecimal price;
    private BigDecimal frequency;
    private BigDecimal peopleNum;
}
