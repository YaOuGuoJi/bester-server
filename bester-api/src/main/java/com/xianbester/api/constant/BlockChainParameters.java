package com.xianbester.api.constant;

import java.math.BigDecimal;

/**
 * @author zhangqiang
 */
public class BlockChainParameters {

    /**
     * 起始发放矿石数量
     */
    public static final BigDecimal DAILY_ORE_LIMITED = new BigDecimal("800.00");

    /**
     * 临时算力过期天数
     */
    public static final int EXPIRATION_DAYS = 90;

    /**
     * 矿石待领取过期天数
     */
    public static final int DAILY_ORE_OVERDUE = 7;

    /**
     * 矿值停止生长的时间间隔
     */
    public static final Integer STOP_GROWING_HOUR = 48;

    /**
     * 设定产出矿石的时间间隔
     */
    public static final String GROWING_INTERVAL = "0 0 0/3 * * ?";

    /**
     * 产出矿石的间隔毫秒数(当产出矿石的时间间隔更改时，也一并更改此数字)
     */
    public static final Integer INTERVAL = 1000 * 60 * 60 * 3;

    /**
     * 待采矿石的过期间隔
     */
    public static final String OVERDUE_INTERVAL = "0 0 0 * * ?";

    /**
     * 计算总原力的时间间隔
     */
    public static final String TOTAL_ORE_INTERVAL = "0 30 23 * * ?";

    /**
     * 最大间隔内生成的矿石个数（根据产出矿石的间隔时间计算)
     */
    public static final Integer MAX_ORE_NUMBER = STOP_GROWING_HOUR / 3;

    /**
     * 每天生产矿石的次数
     */
    public static final BigDecimal TIMES_BY_DAY = new BigDecimal(24 / 3);

    /**
     * 手机号码长度
     */
    public static final Integer PHONE_NUMBER_LENGTH = 11;

    /**
     * 检查发布的活动是否过期
     */
    public static final String FINISHED_EVENT = "0 5 0/3 * * ?";

}
