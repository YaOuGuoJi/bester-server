package com.xianbester.api.service;

import com.xianbester.api.dto.CameraDTO;

import java.util.List;

public interface CameraService {

    List<CameraDTO> selectByCameraIds();

    /**
     * 根据id删除摄像头信息
     *
     * @param cameraId
     * @return
     */
    void deleteByPrimaryKey(Integer cameraId);

    /**
     * 添加摄像头信息
     *
     * @param record
     * @return
     */
    int insert(CameraDTO record);

    /**
     * 根据id查询摄像头信息
     *
     * @param cameraId
     * @return
     */
    CameraDTO selectByPrimaryKey(Integer cameraId);

    /**
     * 选择性修改摄像头信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CameraDTO record);
}
