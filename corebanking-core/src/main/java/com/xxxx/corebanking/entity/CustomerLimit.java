package com.xxxx.corebanking.entity;

import java.util.Date;

public class CustomerLimit {
    private Long limitId;

    private Long customerId;

    private String limitType;

    private String limitCategory;

    private Long originalLimit;

    private Long currentLimit;

    private Long controlLimitId;

    private Date createTime;

    private Date updateTime;

    public Long getLimitId() {
        return limitId;
    }

    public void setLimitId(Long limitId) {
        this.limitId = limitId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }

    public String getLimitCategory() {
        return limitCategory;
    }

    public void setLimitCategory(String limitCategory) {
        this.limitCategory = limitCategory == null ? null : limitCategory.trim();
    }

    public Long getOriginalLimit() {
        return originalLimit;
    }

    public void setOriginalLimit(Long originalLimit) {
        this.originalLimit = originalLimit;
    }

    public Long getCurrentLimit() {
        return currentLimit;
    }

    public void setCurrentLimit(Long currentLimit) {
        this.currentLimit = currentLimit;
    }

    public Long getControlLimitId() {
        return controlLimitId;
    }

    public void setControlLimitId(Long controlLimitId) {
        this.controlLimitId = controlLimitId;
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