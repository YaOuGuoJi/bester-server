package com.xianbester.api.enums;

/**
 * @author zhangqiang
 * @date 2018-12-6
 */

public enum UserVipLevel {

    /**
     * 白银会籍
     */
    NON_VIP(0, "白银会籍"),

    /**
     * 黑金
     */
    BlackGold(10, "黑金会籍");


    UserVipLevel(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int level;

    public String description;

}
