package com.xxxx.corebanking.lending.entity;

import java.sql.Date;

public class LoanAccount_info {
    private Integer loan_id;
    private String product_id;
    private String currency;
    private Date open_date;
    private Integer limit_sequence;
    private String limit_type;
    private Long balance;
    private Date due_date;
    private Integer status;
    private Integer loan_term;
    private String loan_term_unit;
    private Date create_time;
    private Date update_time;

    public Integer getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Integer loan_id) {
        this.loan_id = loan_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }

    public Integer getLimit_sequence() {
        return limit_sequence;
    }

    public void setLimit_sequence(Integer limit_sequence) {
        this.limit_sequence = limit_sequence;
    }

    public String getLimit_type() {
        return limit_type;
    }

    public void setLimit_type(String limit_type) {
        this.limit_type = limit_type;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(Integer loan_term) {
        this.loan_term = loan_term;
    }

    public String getLoan_term_unit() {
        return loan_term_unit;
    }

    public void setLoan_term_unit(String loan_term_unit) {
        this.loan_term_unit = loan_term_unit;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "LoanAccount_info{" +
                "loan_id=" + loan_id +
                ", product_id='" + product_id + '\'' +
                ", currency='" + currency + '\'' +
                ", open_date=" + open_date +
                ", limit_sequence=" + limit_sequence +
                ", limit_type='" + limit_type + '\'' +
                ", balance=" + balance +
                ", due_date=" + due_date +
                ", status=" + status +
                ", loan_term=" + loan_term +
                ", loan_term_unit='" + loan_term_unit + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
