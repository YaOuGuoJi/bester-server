package com.xianbester.api.service;

import com.github.pagehelper.PageInfo;
import com.xianbester.api.dto.ObjectMapDTO;
import com.xianbester.api.dto.OrderRecordDTO;
import com.xianbester.api.dto.OrderRecordJsonDTO;
import com.xianbester.api.dto.OrderRecordRequest;

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
     * 查询今日消费金额和频率
     *
     * @param startTime
     * @param endTime
     * @return
     */
    Map<String, BigDecimal> todayPriceAndFrequency(Date startTime, Date endTime);

}
