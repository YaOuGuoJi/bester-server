package com.xianbester.api.service;

import com.github.pagehelper.PageInfo;
import com.xianbester.api.dto.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuwen
 */
public interface OrderRecordService {

    /**
     * 查询区域订单排名
     *
     * @param request
     * @return
     */
    List<ObjectMapDTO<Integer, Object>> findAreaShopRankByType(OrderRecordRequest request);

    /**
     * 查询时间段内各个区域订单量
     *
     * @param startTime
     * @param endTime
     * @param type
     * @return
     * @see com.xianbester.api.constant.OrderRankType
     */
    Map<Integer, Object> findAreaOrderNumber(Date startTime, Date endTime, int type);

    /**
     * 分页查询商户订单记录
     *
     * @param shopId
     * @param pageNum
     * @param pageSize
     * @param startTime
     * @param endTime
     * @return
     */
    PageInfo<OrderRecordDTO> pageFindOrderRecordByShopId(int shopId, int pageNum, int pageSize,
                                                         Date startTime, Date endTime);

    /**
     * 分页查询用户订单记录
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @param startTime
     * @param endTime
     * @return
     */
    PageInfo<OrderRecordDTO> pageFindOrderRecordByUserId(int userId, int pageNum, int pageSize,
                                                         Date startTime, Date endTime);

    /**
     * 查询商户订单排序
     *
     * @param limit
     * @param startTime
     * @param endTime
     * @param type
     * @return
     * @see com.xianbester.api.constant.OrderRankType
     */
    Map<Integer, Object> findShopIdsRankByOrders(int limit, Date startTime, Date endTime, int type);

    /**
     * 查询单个订单详细信息
     *
     * @param orderId
     * @return
     */
    OrderRecordDTO findOrderDetailsByOrderId(int orderId);

    /**
     * 查询用户订单记录
     *
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderRecordDTO> findOrdersByUserId(int userId, Date startTime, Date endTime);

    /**
     * 查询商户订单记录
     *
     * @param shopId
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderRecordDTO> findOrdersByShopId(int shopId, Date startTime, Date endTime);

    /**
     * 插入订单信息
     *
     * @param orderRecordDTO
     * @return
     */
    int addOrderInfo(OrderRecordDTO orderRecordDTO);

    /**
     * 查询用户全年订单
     *
     * @param userId 用户ID
     * @param year   年份
     * @return
     */
    List<OrderRecordJsonDTO> findOrderRecordByUserId(String userId, String year, String month);

    /**
     * 查找大于我的消费额的用户数
     *
     * @param totalPrice
     * @return
     */
    int findUsersWhoAreLargeThanMySpending(BigDecimal totalPrice, String year, String month);

    /**
     * 查询小镇指定区间的订单统计  包括总消费次数，总消费额，消费人数 ,客单价（总消费额/消费人数）
     * @param request
     * @return
     */
    OrderRecordCountDTO townOrderRecordCount(OrderRecordRequest request);

    /**
     * 查询7日或30日订单业态数量
     *
     * @param day
     * @return
     */
    Map<Object, Integer> selectTypeCount(int day);

    /**
     * 7日或30日订单类型分布
     * @param startTime
     * @param endTime
     * @return
     */
    Map<String,Integer> orderTypeDistribution(Date startTime,Date endTime);

}
