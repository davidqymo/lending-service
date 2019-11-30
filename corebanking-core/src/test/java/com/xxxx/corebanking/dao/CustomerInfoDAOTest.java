package com.xxxx.corebanking.dao;
import java.sql.Timestamp;
import java.text.ParseException;



import com.xxxx.corebanking.config.PackageConfig;
import com.xxxx.corebanking.entity.Customer_info;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = PackageConfig.class)
public class CustomerInfoDAOTest {

    @Autowired
    SqlSession session;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void getCustomerById() {
        CustomerInfoDAO customerInfoDAO = session.getMapper( CustomerInfoDAO.class );
        Customer_info custom = customerInfoDAO.getCustomerById( 13 );
        System.out.println(custom );
        Assert.assertNotNull( custom.getCustomer_id() );

    }

    @org.junit.Test
    public void getAll() {
    }

    @org.junit.Test
    public void insertCustomer() throws ParseException {


        Customer_info custom = new Customer_info();
        custom.setGender( 1 );
        custom.setCustomer_name( "浪翻云" );
        custom.setDate_of_birth(new java.sql.Date(System.currentTimeMillis()));

        CustomerInfoDAO customerInfoDAO = session.getMapper( CustomerInfoDAO.class );
        System.out.println( customerInfoDAO.insertCustomer( custom ) );
        session.commit();
        System.out.println(custom.getCustomer_id());
        Assert.assertNotNull( custom.getCustomer_id() );

    }

    @org.junit.Test
    public void updateCustomer() {
    }

    @org.junit.Test
    public void deleteCustomer() {
    }

    @org.junit.Test
    public void getAllCustomerMap() {
    }
}
