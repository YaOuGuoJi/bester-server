package com.xianbester.api.service;

import com.xianbester.api.dto.CameraRecordDTO;
import com.xianbester.api.dto.TownCountDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CameraRecordService {

    /**
     * 根据摄像头id列表查询最新记录
     *
     * @param cameraIds
     * @return
     */
    List<CameraRecordDTO> batchSelectAllRecords(List<Integer> cameraIds);

    /**
     * 根据id删除摄像头记录
     *
     * @param cRecordId
     * @return
     */
    void deleteByPrimaryKey(Integer cRecordId);

    /**
     * 添加摄像头记录
     *
     * @param record
     * @return
     */
    int insert(CameraRecordDTO record);

    /**
     * 根据id查询摄像头记录
     *
     * @param cRecordId
     * @return
     */
    CameraRecordDTO selectByPrimaryKey(Integer cRecordId);

    /**
     * 根据条件修改摄像头记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CameraRecordDTO record);

    /**
     * 根据时间查询总客流量概况
     *
     * @param days
     * @return
     */
    Map<String, Integer> queryVisitorsByTime(int days);

    /**
     * 查询各区域在指定时间范围内的人流量统计
     *
     * @param start
     * @param end
     * @return
     */
    List<TownCountDTO> locationPeopleCount(Date start, Date end);
}
