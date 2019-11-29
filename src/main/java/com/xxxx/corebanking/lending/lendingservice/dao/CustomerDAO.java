package com.xxxx.corebanking.lending.lendingservice.dao;
import	java.util.HashMap;

import com.xxxx.corebanking.lending.lendingservice.entity.CustomerPageParameters;
import com.xxxx.corebanking.lending.lendingservice.entity.Customer_info;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Map;

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

    public List<Customer_info> getAllCustomer(int currentPage,int pageSize) {
        List<Customer_info> result = session.selectList( MAPPER_PACKAGE + "selectAll",
                new CustomerPageParameters((currentPage - 1)* pageSize,pageSize));
        return result;
    }


    public List<Customer_info> getAllCustomerMap(int currentPage,int pageSize) {

        Map<String,Integer> paramters = new HashMap<String, Integer> ();
        paramters.put( "startIndex", (currentPage -1)*pageSize );
        paramters.put("pageNumber", pageSize);

        List<Customer_info> result = session.selectList( MAPPER_PACKAGE + "selectAll", paramters);
        return result;
    }

    public List<Customer_info> getAll(int currentPage,int pageSize) {
        RowBounds rowBounds = new RowBounds( (currentPage -1 )*pageSize, pageSize );
        List<Customer_info> result = session.selectList( MAPPER_PACKAGE + "getAll", rowBounds);
        return result;
    }

}
