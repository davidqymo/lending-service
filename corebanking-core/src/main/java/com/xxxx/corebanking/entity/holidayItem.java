package com.xxxx.corebanking.entity;

import java.util.Date;

public class holidayItem extends holidayItemKey {
    private String holidayDetail;

    private Date createTime;

    private Date updateTime;

    public String getHolidayDetail() {
        return holidayDetail;
    }

    public void setHolidayDetail(String holidayDetail) {
        this.holidayDetail = holidayDetail == null ? null : holidayDetail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}