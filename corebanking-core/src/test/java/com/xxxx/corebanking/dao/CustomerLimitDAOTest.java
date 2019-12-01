package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.config.PackageConfig;
import com.xxxx.corebanking.entity.Customer_limit;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = PackageConfig.class)
public class CustomerLimitDAOTest {

    @Autowired
    SqlSession sqlSession;

    @Test
    public void addCustomerLimit() {

        CustomerLimitDAO dao = sqlSession.getMapper( CustomerLimitDAO.class );
        Customer_limit customer_limit = new Customer_limit( );
        customer_limit.setCustomer_id( 1L );
        customer_limit.setLimit_category( 'A' );
        customer_limit.setControl_limit_id( 0L );
        customer_limit.setCurrent_limit( 10000000L );
        customer_limit.setOriginal_limit( 1000000L );
        customer_limit.setLimit_type( "LNS" );
        customer_limit.setCreate_time( new Timestamp( System.currentTimeMillis() ) );
        customer_limit.setUpdate_time( new Timestamp( System.currentTimeMillis() ) );

        System.out.println( dao.addCustomerLimit( customer_limit ) );

    }
}
