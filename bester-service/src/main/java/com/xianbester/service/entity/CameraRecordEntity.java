package com.xianbester.service.entity;

import java.util.Date;

public class CameraRecordEntity {
    private Integer cRecordId;

    private Integer cameraId;

    private Date crAddTime;

    private Date crUpdateTime;

    private Integer crMaleNumber;

    private Integer crFemaleNumber;

    public Integer getcRecordId() {
        return cRecordId;
    }

    public void setcRecordId(Integer cRecordId) {
        this.cRecordId = cRecordId;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public Date getCrAddTime() {
        return crAddTime;
    }

    public void setCrAddTime(Date crAddTime) {
        this.crAddTime = crAddTime;
    }

    public Date getCrUpdateTime() {
        return crUpdateTime;
    }

    public void setCrUpdateTime(Date crUpdateTime) {
        this.crUpdateTime = crUpdateTime;
    }

    public Integer getCrMaleNumber() {
        return crMaleNumber;
    }

    public void setCrMaleNumber(Integer crMaleNumber) {
        this.crMaleNumber = crMaleNumber;
    }

    public Integer getCrFemaleNumber() {
        return crFemaleNumber;
    }

    public void setCrFemaleNumber(Integer crFemaleNumber) {
        this.crFemaleNumber = crFemaleNumber;
    }
}
