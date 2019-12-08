package com.xxxx.corebanking;

import com.xxxx.corebanking.config.CoreBankingPackageConfig;
import com.xxxx.corebanking.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class mainApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext( CoreBankingPackageConfig.class );
        CustomerService service = ac.getBean( CustomerService.class );
        service.InsertCustomerAndMapping( );
    }
}
