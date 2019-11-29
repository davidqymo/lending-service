package com.xxxx.corebanking.lending.lendingservice.dao;

import com.xxxx.corebanking.lending.lendingservice.entity.Customer_info;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

    @Autowired
    @Qualifier("mybatisSession")
    SqlSession session;

    public final static String MAPPER_PACKAGE = "com.xxxx.corebanking.lending.lendingservice.entity.CustomerMapper.";

    public Customer_info getCustomerbyId(int id) {
        Customer_info info = session.selectOne(MAPPER_PACKAGE + "SelectCustomer",id );
        return info;
    }

    public int insertCustomer(Customer_info customer) {
        int result = session.insert( MAPPER_PACKAGE +"AddCustomer", customer);
        session.commit();
        return result;
    }

    public int updateCustomer(Customer_info customer) {
        int result = session.update( MAPPER_PACKAGE + "UpdateCustomer",customer );
        session.commit();
        return result;
    }

    public int deleteCustomer(int id) {
        int result = session.delete(MAPPER_PACKAGE + "DeleteCustomer",id);
        session.commit();
        return result;
    }


}
