package com.xxxx.corebanking.lending.entity;

import java.util.Date;

public class LoanRepaymentHistoryItem extends LoanRepaymentHistoryItemKey {
    private Long instalmentAmount;

    private Long instalmentAmountPaid;

    private Long principalPortion;

    private Long interstPortion;

    private Long principalPortionPaid;

    private Long interstPortionPaid;

    private String instalmentStatus;

    private Date createTime;

    private Date updateTime;

    public Long getInstalmentAmount() {
        return instalmentAmount;
    }

    public void setInstalmentAmount(Long instalmentAmount) {
        this.instalmentAmount = instalmentAmount;
    }

    public Long getInstalmentAmountPaid() {
        return instalmentAmountPaid;
    }

    public void setInstalmentAmountPaid(Long instalmentAmountPaid) {
        this.instalmentAmountPaid = instalmentAmountPaid;
    }

    public Long getPrincipalPortion() {
        return principalPortion;
    }

    public void setPrincipalPortion(Long principalPortion) {
        this.principalPortion = principalPortion;
    }

    public Long getInterstPortion() {
        return interstPortion;
    }

    public void setInterstPortion(Long interstPortion) {
        this.interstPortion = interstPortion;
    }

    public Long getPrincipalPortionPaid() {
        return principalPortionPaid;
    }

    public void setPrincipalPortionPaid(Long principalPortionPaid) {
        this.principalPortionPaid = principalPortionPaid;
    }

    public Long getInterstPortionPaid() {
        return interstPortionPaid;
    }

    public void setInterstPortionPaid(Long interstPortionPaid) {
        this.interstPortionPaid = interstPortionPaid;
    }

    public String getInstalmentStatus() {
        return instalmentStatus;
    }

    public void setInstalmentStatus(String instalmentStatus) {
        this.instalmentStatus = instalmentStatus == null ? null : instalmentStatus.trim( );
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
