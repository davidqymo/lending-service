package com.xxxx.corebanking.lending.entity;

import java.util.Date;

public class LoanPenaltyItemKey {
    private Long loanId;

    private Date calculationEndDate;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Date getCalculationEndDate() {
        return calculationEndDate;
    }

    public void setCalculationEndDate(Date calculationEndDate) {
        this.calculationEndDate = calculationEndDate;
    }
}