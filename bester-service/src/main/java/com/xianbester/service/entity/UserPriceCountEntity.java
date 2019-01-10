package com.xianbester.service.entity;

import lombok.Data;

@Data
public class UserPriceCountEntity {
    private Integer lessAverage;
    private Integer nearAverage;
    private Integer overAverage;
}
