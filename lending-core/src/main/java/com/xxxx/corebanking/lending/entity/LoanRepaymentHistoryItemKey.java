package com.xxxx.corebanking.lending.entity;

import java.util.Date;

public class LoanRepaymentHistoryItemKey {
    private Long loanId;

    private Date instalmentDueDate;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Date getInstalmentDueDate() {
        return instalmentDueDate;
    }

    public void setInstalmentDueDate(Date instalmentDueDate) {
        this.instalmentDueDate = instalmentDueDate;
    }
}