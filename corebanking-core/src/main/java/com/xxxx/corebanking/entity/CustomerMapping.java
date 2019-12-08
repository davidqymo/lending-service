package com.xxxx.corebanking.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomerMapping {
    private Long customerId;

    private String systemCode;

    private String extCustomerNum;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode == null ? null : systemCode.trim();
    }

    public String getExtCustomerNum() {
        return extCustomerNum;
    }

    public void setExtCustomerNum(String extCustomerNum) {
        this.extCustomerNum = extCustomerNum == null ? null : extCustomerNum.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
