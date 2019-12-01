package com.xxxx.corebanking.entity;

import java.util.Date;

public class currency {
    private String currencyCode;

    private Boolean decimalPoint;

    private Long exchangeRate;

    private Date createTime;

    private Date updateTime;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    public Boolean getDecimalPoint() {
        return decimalPoint;
    }

    public void setDecimalPoint(Boolean decimalPoint) {
        this.decimalPoint = decimalPoint;
    }

    public Long getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Long exchangeRate) {
        this.exchangeRate = exchangeRate;
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