package com.xxxx.corebanking.service;

import com.xxxx.corebanking.config.CoreBankingPackageConfig;
import com.xxxx.corebanking.dao.CustomerMapper;
import com.xxxx.corebanking.dao.CustomerMappingMapper;
import com.xxxx.corebanking.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CoreBankingPackageConfig.class)

public class CustomerServiceTest {

    @Autowired
    CustomerService service;

    @Test
//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertCustomerAndMapping() throws Exception {

        service.InsertCustomerAndMapping( );
    }

//    @Test
//    public void insertCustomerMapping() {
//    }
}
