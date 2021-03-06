package com.xianbester.service.dao;

import com.xianbester.service.entity.OreRecordEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author liuwen
 * @date 2018/11/2
 */
public interface OreRecordDao {
    // 在这里新增接口

    /**
     * 查询所有用户的最新领取记录
     *
     * @param time
     * @return
     */
    List<Integer> selectMaxUpdateTime(@Param("time") Date time);

    /**
     * 修改所有过期矿石状态
     *
     * @param userIdList 用户IdList
     * @return
     */
    int updateOverduePower(@Param("userIdList") List<Integer> userIdList);

    /**
     * 写入用户间隔内生成的矿石
     *
     * @param userId 用户ID
     * @param source 矿石来源
     * @param ore 矿值
     * @param status 矿石状态
     */
    void insertUserOreByInterval(@Param("userId") Integer userId,
                                 @Param("source") String source,
                                 @Param("ore") BigDecimal ore,
                                 @Param("status") Integer status);

    /**
     * 查找用户生成的矿值的个数
     *
     * @param status 矿石状态
     * @param userId 用户ID
     * @return
     */
    Integer findGrowingOreByInterval(@Param("userId") Integer userId, @Param("status") Integer status);

    /**
     * 根据矿id查矿记录
     *
     * @param id
     * @return
     */
    OreRecordEntity showOreById(@Param("id") Integer id);

    /**
     * 根据矿的id把状态为2的矿修改为1(收矿)
     *
     * @param id
     * @return
     */

    Integer receiveOre(@Param("id") Integer id);
    /**
     * 通过用户Id和状态查询矿石记录
     *
     * @param userId
     * @return
     */
    List<OreRecordEntity> queryAllOreRecordByUserId(@Param("userId") Integer userId, @Param("status") int status);

    /**
     * 通过用户ID查询已领取矿石总量
     *
     * @param userId
     * @return
     */
    BigDecimal queryOreNumbByUserId(@Param("userId") Integer userId);


}
