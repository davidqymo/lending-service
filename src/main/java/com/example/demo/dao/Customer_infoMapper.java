package com.example.demo.dao;

import com.xxxx.demo.model.Customer_info;

public interface Customer_infoMapper {
    int deleteByPrimaryKey(Long customerId);

    int insert(Customer_info record);

    int insertSelective(Customer_info record);

    Customer_info selectByPrimaryKey(Long customerId);

    int updateByPrimaryKeySelective(Customer_info record);

    int updateByPrimaryKey(Customer_info record);
}