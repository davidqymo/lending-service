package com.xxxx.corebanking.service;

import com.xxxx.corebanking.dao.CustomerMapper;
import com.xxxx.corebanking.dao.CustomerMappingMapper;
import com.xxxx.corebanking.entity.Customer;
import com.xxxx.corebanking.entity.CustomerMapping;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CustomerService {


    @Autowired
    CustomerMapper customerDao;
    @Autowired
    CustomerMappingMapper customerMappingDao;


    @Transactional()
    public String InsertCustomerAndMapping() throws Exception {
        Customer customer = new Customer( );

        LocalDate DayOfBirth = LocalDate.parse( "1982-04-05" );
        LocalDateTime now = LocalDateTime.now( );

        customer.setCustomerName( "爱奇艺" );
        customer.setCreateTime( now );
        customer.setUpdateTime( now );
        customer.setDateOfBirth( DayOfBirth );
        customer.setGender( 1 );


        customerDao.insert( customer );

        CustomerMapping customerMapping = new CustomerMapping( );
        customerMapping.setCustomerId( customer.getCustomerId( ) );
        customerMapping.setCreateTime( now );
        customerMapping.setUpdateTime( now );
//        customerMapping.setSystemCode( "HUB" );
        customerMapping.setExtCustomerNum( "CN-HSBC-002-12346-081" );

        customerMappingDao.insert( customerMapping );

        return "Good";
    }


}
