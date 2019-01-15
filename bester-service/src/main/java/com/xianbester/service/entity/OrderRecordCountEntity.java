package com.xianbester.service.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liang
 */
@Data
public class OrderRecordCountEntity {
    private BigDecimal price;
    private Long frequency;
    private Long peopleNum;
}
