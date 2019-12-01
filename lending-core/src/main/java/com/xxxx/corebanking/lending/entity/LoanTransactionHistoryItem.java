package com.xxxx.corebanking.lending.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LoanTransactionHistoryItem {
    private Long dealId;

    private Date transactionDate;

    private Long loanId;

    private Long repaymentAccountId;

    private String currency;

    private Long transactionAmout;

    private Long localCurrencyTransactionAmount;

    private BigDecimal exchangeRate;

    private String narrative;

    private Long principalAmount;

    private Long interestAmount;

    private Long overduePenaltyAmount;

    private Date createTime;

    private Date updateTime;

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getRepaymentAccountId() {
        return repaymentAccountId;
    }

    public void setRepaymentAccountId(Long repaymentAccountId) {
        this.repaymentAccountId = repaymentAccountId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim( );
    }

    public Long getTransactionAmout() {
        return transactionAmout;
    }

    public void setTransactionAmout(Long transactionAmout) {
        this.transactionAmout = transactionAmout;
    }

    public Long getLocalCurrencyTransactionAmount() {
        return localCurrencyTransactionAmount;
    }

    public void setLocalCurrencyTransactionAmount(Long localCurrencyTransactionAmount) {
        this.localCurrencyTransactionAmount = localCurrencyTransactionAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative == null ? null : narrative.trim( );
    }

    public Long getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Long principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Long getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Long interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Long getOverduePenaltyAmount() {
        return overduePenaltyAmount;
    }

    public void setOverduePenaltyAmount(Long overduePenaltyAmount) {
        this.overduePenaltyAmount = overduePenaltyAmount;
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
