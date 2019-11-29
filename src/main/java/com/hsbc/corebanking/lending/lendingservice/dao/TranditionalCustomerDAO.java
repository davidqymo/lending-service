package com.hsbc.corebanking.lending.lendingservice.dao;

import com.hsbc.corebanking.lending.lendingservice.SessionFactoryUtl;
import com.hsbc.corebanking.lending.lendingservice.entity.Customer_info;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class TranditionalCustomerDAO {

    public final static String MAPPER_PACKAGE = "com.hsbc.corebanking.lending.lendingservice.entity.CustomerMapper.";

    public Customer_info getCustomerbyId(int id) throws IOException {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        Customer_info info = session.selectOne(MAPPER_PACKAGE + "SelectCustomer",id );
        session.close();
        return info;
    }

    public int insertCustomer(Customer_info customer) throws IOException {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        int result = session.insert( MAPPER_PACKAGE +"AddCustomer", customer);
        session.commit();
        session.close();
        return result;
    }

    public int updateCustomer(Customer_info customer) throws IOException {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        int result = session.update( MAPPER_PACKAGE + "UpdateCustomer",customer );
        session.commit();
        session.close();
        return result;
    }

    public int deleteCustomer(int id) throws IOException {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        int result = session.delete(MAPPER_PACKAGE + "DeleteCustomer",id);
        session.commit();
        session.close();
        return result;
    }
}
