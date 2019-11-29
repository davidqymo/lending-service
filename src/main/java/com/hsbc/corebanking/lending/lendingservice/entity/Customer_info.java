package com.hsbc.corebanking.lending.lendingservice.entity;

import java.sql.Date;

public class Customer_info {
    private Integer customer_id;
    private String customer_name;
    private Integer gender;
    private Date date_of_birth;
    private Date create_time;
    private Date update_time;

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
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
        return "Customer_info{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
