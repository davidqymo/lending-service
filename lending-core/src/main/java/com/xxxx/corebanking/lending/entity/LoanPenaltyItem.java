package com.xxxx.corebanking.lending.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LoanPenaltyItem extends LoanPenaltyItemKey {
    private Date lastInterestCalculationDate;

    private BigDecimal debitInterestRate;

    private Long overdueBalanceForInterestCalculation;

    private Long overdueInterestAccruals;

    private Long overdueInterestCollected;

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

    public Long getOverdueBalanceForInterestCalculation() {
        return overdueBalanceForInterestCalculation;
    }

    public void setOverdueBalanceForInterestCalculation(Long overdueBalanceForInterestCalculation) {
        this.overdueBalanceForInterestCalculation = overdueBalanceForInterestCalculation;
    }

    public Long getOverdueInterestAccruals() {
        return overdueInterestAccruals;
    }

    public void setOverdueInterestAccruals(Long overdueInterestAccruals) {
        this.overdueInterestAccruals = overdueInterestAccruals;
    }

    public Long getOverdueInterestCollected() {
        return overdueInterestCollected;
    }

    public void setOverdueInterestCollected(Long overdueInterestCollected) {
        this.overdueInterestCollected = overdueInterestCollected;
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