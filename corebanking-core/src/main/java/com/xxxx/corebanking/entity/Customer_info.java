package com.xxxx.corebanking.entity;


import java.sql.Date;
import java.sql.Timestamp;


public class Customer_info {
    private Integer customer_id;
    private String customer_name;
    private Integer gender;
    private Date date_of_birth;

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


    @Override
    public String toString() {
        return "Customer_info{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +

                '}';
    }
}
