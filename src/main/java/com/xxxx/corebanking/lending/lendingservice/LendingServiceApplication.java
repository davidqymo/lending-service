package com.xxxx.corebanking.lending.lendingservice;


import com.xxxx.corebanking.lending.lendingservice.dao.CustomerDAO;
import com.xxxx.corebanking.lending.lendingservice.entity.Customer_info;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;


public class LendingServiceApplication {

    public static void main(String[] args)
    {
//        SpringApplication.run( LendingServiceApplication.class, args );
        ApplicationContext ac = new AnnotationConfigApplicationContext( MqConfig.class );

        CustomerDAO dao = ac.getBean( CustomerDAO.class );
        Customer_info customer_info = dao.getCustomerbyId( 13 );


        System.out.println(customer_info );


        customer_info.setCustomer_name( "Summer Qiu" );
        customer_info.setUpdate_time( new Date(System.currentTimeMillis()) );
        System.out.println( dao.updateCustomer( customer_info ) );

        System.out.println(dao.getCustomerbyId( 13 ) );

    }


    
}


