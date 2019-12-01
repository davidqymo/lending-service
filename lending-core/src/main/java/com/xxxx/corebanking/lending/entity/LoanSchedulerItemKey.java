package com.xxxx.corebanking.lending.entity;

import java.util.Date;

public class LoanSchedulerItemKey {
    private Long loanId;

    private Date startDate;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}