package com.xxxx.corebanking.lending.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LoanSchedulerItem extends LoanSchedulerItemKey {
    private String repaymentScheme;

    private BigDecimal debitInterestRate;

    private Date nextInstalmentDate;

    private Long nextInstalmentAmount;

    private Date nextInterestApplicationDate;

    private String instalmentFrequency;

    private String interestApplicationFrequency;

    private Date nextInterestReviewDate;

    private Date createTime;

    private Date updateTime;

    public String getRepaymentScheme() {
        return repaymentScheme;
    }

    public void setRepaymentScheme(String repaymentScheme) {
        this.repaymentScheme = repaymentScheme == null ? null : repaymentScheme.trim( );
    }

    public BigDecimal getDebitInterestRate() {
        return debitInterestRate;
    }

    public void setDebitInterestRate(BigDecimal debitInterestRate) {
        this.debitInterestRate = debitInterestRate;
    }

    public Date getNextInstalmentDate() {
        return nextInstalmentDate;
    }

    public void setNextInstalmentDate(Date nextInstalmentDate) {
        this.nextInstalmentDate = nextInstalmentDate;
    }

    public Long getNextInstalmentAmount() {
        return nextInstalmentAmount;
    }

    public void setNextInstalmentAmount(Long nextInstalmentAmount) {
        this.nextInstalmentAmount = nextInstalmentAmount;
    }

    public Date getNextInterestApplicationDate() {
        return nextInterestApplicationDate;
    }

    public void setNextInterestApplicationDate(Date nextInterestApplicationDate) {
        this.nextInterestApplicationDate = nextInterestApplicationDate;
    }

    public String getInstalmentFrequency() {
        return instalmentFrequency;
    }

    public void setInstalmentFrequency(String instalmentFrequency) {
        this.instalmentFrequency = instalmentFrequency == null ? null : instalmentFrequency.trim( );
    }

    public String getInterestApplicationFrequency() {
        return interestApplicationFrequency;
    }

    public void setInterestApplicationFrequency(String interestApplicationFrequency) {
        this.interestApplicationFrequency = interestApplicationFrequency == null ? null : interestApplicationFrequency.trim( );
    }

    public Date getNextInterestReviewDate() {
        return nextInterestReviewDate;
    }

    public void setNextInterestReviewDate(Date nextInterestReviewDate) {
        this.nextInterestReviewDate = nextInterestReviewDate;
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
