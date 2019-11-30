package com.xxxx.corebanking.entity;


import java.sql.Timestamp;

public class Customer_limit {
    private Integer limit_id;
    private Integer customer_id;
    private String limit_type;
    private Character limit_category;
    private Long original_limit;
    private Long current_limit;
    private Integer control_limit_id;
    private Timestamp create_time;
    private Timestamp update_time;

    public Integer getLimit_id() {
        return limit_id;
    }

    public void setLimit_id(Integer limit_id) {
        this.limit_id = limit_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getLimit_type() {
        return limit_type;
    }

    public void setLimit_type(String limit_type) {
        this.limit_type = limit_type;
    }

    public Character getLimit_category() {
        return limit_category;
    }

    public void setLimit_category(Character limit_category) {
        this.limit_category = limit_category;
    }

    public Long getOriginal_limit() {
        return original_limit;
    }

    public void setOriginal_limit(Long original_limit) {
        this.original_limit = original_limit;
    }

    public Long getCurrent_limit() {
        return current_limit;
    }

    public void setCurrent_limit(Long current_limit) {
        this.current_limit = current_limit;
    }

    public Integer getControl_limit_id() {
        return control_limit_id;
    }

    public void setControl_limit_id(Integer control_limit_id) {
        this.control_limit_id = control_limit_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }
}
