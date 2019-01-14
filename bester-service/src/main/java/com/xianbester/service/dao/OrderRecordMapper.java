package com.xianbester.service.dao;

import com.xianbester.service.entity.OrderNumberEntity;
import com.xianbester.service.entity.OrderRecordEntity;
import com.xianbester.service.entity.OrderRecordJsonEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuwen
 */
public interface OrderRecordMapper {

    /**
     * 查询区域内商户订单量排名
     *
     * @param areaId
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderNumberEntity> findAreaShopOrderNumRank(@Param("areaId") int areaId,
                                                     @Param("limit") int limit,
                                                     @Param("startTime") Date startTime,
                                                     @Param("endTime") Date endTime);

    /**
     * 查询区域内商户订单总额排名
     *
     * @param areaId
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderNumberEntity> findAreaShopOrderPriceRank(@Param("areaId") int areaId,
                                                       @Param("limit") int limit,
                                                       @Param("startTime") Date startTime,
                                                       @Param("endTime") Date endTime);

    /**
     * 查询时间段内各个区域的订单量
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderNumberEntity> findAreaOrderNum(@Param("startTime") Date startTime,
                                             @Param("endTime") Date endTime);

    /**
     * 查询时间段内各个区域的订单总额
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderNumberEntity> findAreaOrderPrice(@Param("startTime") Date startTime,
                                               @Param("endTime") Date endTime);

    /**
     * 查询时间段内订单量最多的商户
     *
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderNumberEntity> findOrderNumTop(@Param("limit") int limit,
                                            @Param("startTime") Date startTime,
                                            @Param("endTime") Date endTime);

    /**
     * 查询时间段内订单总额最大的商户
     *
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderNumberEntity> findOrderPriceTop(@Param("limit") int limit,
                                              @Param("startTime") Date startTime,
                                              @Param("endTime") Date endTime);

    /**
     * 根据orderId查询订单
     *
     * @param orderId
     * @return
     */
    OrderRecordEntity selectById(@Param("orderId") int orderId);

    /**
     * 新增订单信息
     *
     * @param orderRecordEntity
     * @return
     */
    int addOrderInfo(@Param("orderRecordEntity") OrderRecordEntity orderRecordEntity);

    /**
     * 更新订单信息
     *
     * @param orderRecordEntity
     * @return
     */
    int updateOrderInfo(@Param("orderRecordEntity") OrderRecordEntity orderRecordEntity);

    /**
     * 根据userId查询订单记录
     *
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderRecordEntity> selectOrderRecordsByUserId(@Param("userId") int userId,
                                                       @Param("start") Date startTime,
                                                       @Param("end") Date endTime);

    /**
     * 查询shopId一段时间内的订单记录
     *
     * @param shopId
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderRecordEntity> selectOrderRecordsByShopId(@Param("shopId") int shopId,
                                                       @Param("start") Date startTime,
                                                       @Param("end") Date endTime);

    /**
     * 根据用户ID查询该用户所有订单
     *
     * @param userId 用户ID
     * @return
     */
    List<OrderRecordJsonEntity> findOrderRecordByUserId(@Param("userId") String userId,
                                                        @Param("year") String year,
                                                        @Param("month") String month);

    /**
     * 查找大于我的消费额的用户数
     *
     * @param totalPrice 当前用户消费额
     * @return
     */
    int findUsersWhoAreLargeThanMySpending(@Param("totalPrice") BigDecimal totalPrice,
                                           @Param("year") String year,
                                           @Param("month") String month);

    /**
     * 查询今日销售额和频率
     *
     * @param startTime
     * @param endTime
     * @return
     */
    Map<String, Object> townOrderRecordCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
