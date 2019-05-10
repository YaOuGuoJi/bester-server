package com.xianbester.service.dao;

import com.xianbester.service.entity.CameraRecordEntity;
import com.xianbester.service.entity.CountEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 摄像头记录
 */
public interface RecordMapper {

    /**
     * 根据cameraId列表批量查询
     *
     * @param cameraIdList
     * @return
     */
    List<CameraRecordEntity> batchSelectNewRecords(@Param("cameraIdList") List<Integer> cameraIdList);

    /**
     * 根据id删除摄像头记录
     *
     * @param cRecordId
     * @return
     */
    int deleteByPrimaryKey(@Param("cRecordId") Integer cRecordId);

    /**
     * 添加摄像头记录
     *
     * @param record
     * @return
     */
    int insert(@Param("record") CameraRecordEntity record);

    /**
     * 根据条件添加摄像头记录
     *
     * @param record
     * @return
     */
    int insertSelective(@Param("record") CameraRecordEntity record);

    /**
     * 根据时间查询总客流量概况
     *
     * @param startTime
     * @param endTime
     * @return
     */
    CountEntity queryVisitorsByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 根据id查询摄像头记录
     *
     * @param cRecordId
     * @return
     */
    CameraRecordEntity selectByPrimaryKey(@Param("cRecordId") Integer cRecordId);

    /**
     * 根据id查询摄像头记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(@Param("record") CameraRecordEntity record);

    /**
     * 根据条件修改摄像头记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(@Param("record") CameraRecordEntity record);

    /**
     * 查询指定区域活动时间段内的参与人数
     *
     * @param start
     * @param end
     * @param cameraIdList
     * @return
     */
    CountEntity checkNumberOfParticipantsInterval(@Param("cameraIdList") List<Integer> cameraIdList,
                                                  @Param("start") Date start,
                                                  @Param("end") Date end);


}
