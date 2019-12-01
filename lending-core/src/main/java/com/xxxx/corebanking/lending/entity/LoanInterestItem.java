package com.xxxx.corebanking.lending.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LoanInterestItem extends LoanInterestItemKey {
    private Date lastInterestCalculationDate;

    private BigDecimal debitInterestRate;

    private Long balanceForInterestCalculation;

    private Long interestAccruals;

    private Long interestCollected;

    private Date createTime;

    private Date updateTime;

    public Date getLastInterestCalculationDate() {
        return lastInterestCalculationDate;
    }

    public void setLastInterestCalculationDate(Date lastInterestCalculationDate) {
        this.lastInterestCalculationDate = lastInterestCalculationDate;
    }

    public BigDecimal getDebitInterestRate() {
        return debitInterestRate;
    }

    public void setDebitInterestRate(BigDecimal debitInterestRate) {
        this.debitInterestRate = debitInterestRate;
    }

    public Long getBalanceForInterestCalculation() {
        return balanceForInterestCalculation;
    }

    public void setBalanceForInterestCalculation(Long balanceForInterestCalculation) {
        this.balanceForInterestCalculation = balanceForInterestCalculation;
    }

    public Long getInterestAccruals() {
        return interestAccruals;
    }

    public void setInterestAccruals(Long interestAccruals) {
        this.interestAccruals = interestAccruals;
    }

    public Long getInterestCollected() {
        return interestCollected;
    }

    public void setInterestCollected(Long interestCollected) {
        this.interestCollected = interestCollected;
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