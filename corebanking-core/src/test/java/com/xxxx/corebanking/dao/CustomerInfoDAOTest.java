package com.xxxx.corebanking.dao;
import java.sql.Timestamp;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;


import com.xxxx.corebanking.config.PackageConfig;
import com.xxxx.corebanking.entity.Customer_info;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = PackageConfig.class)
public class CustomerInfoDAOTest {


    @Autowired
    SqlSession session;

    @Autowired
    SqlSessionFactory sessionFactory;

    SqlSession tempTestSession;

    @org.junit.Before
    public void setUp() throws Exception {
        tempTestSession = sessionFactory.openSession();
        CustomerInfoDAO dao = tempTestSession.getMapper( CustomerInfoDAO.class );

        for (int i = 0; i < 15; i++) {
            Customer_info custom = new Customer_info();
            custom.setGender( 1 );
            custom.setCustomer_name( "测试工具人"+i );
            custom.setDate_of_birth(new Date(System.currentTimeMillis()));
            custom.setCreate_time( new Timestamp(System.currentTimeMillis()));
            custom.setUpdate_time( new Timestamp(System.currentTimeMillis()));
            System.out.println(custom );
            dao.insertCustomer(custom);
        }
        System.out.println("插入15个工具人" );
    }

    @Test
    public void getCustomerById() {
        Customer_info custom = new Customer_info();
        custom.setGender( 1 );
        custom.setCustomer_name( "浪翻云" );
        custom.setDate_of_birth(new Date(System.currentTimeMillis()));
        custom.setCreate_time( new Timestamp(System.currentTimeMillis()));
        custom.setUpdate_time( new Timestamp(System.currentTimeMillis()));
        System.out.println(custom );
        SqlSession tempSession = sessionFactory.openSession();
        CustomerInfoDAO dao = tempSession.getMapper( CustomerInfoDAO.class );
        dao.insertCustomer(custom);

        Customer_info new_custom = dao.getCustomerById( custom.getCustomer_id().intValue() );

        Assert.assertEquals( custom.getCustomer_id(), new_custom.getCustomer_id() );
        Assert.assertEquals( custom.getCustomer_name(), new_custom.getCustomer_name() );
        Assert.assertEquals( custom.getGender(), new_custom.getGender() );
        Assert.assertEquals( custom.getDate_of_birth().toString(), new_custom.getDate_of_birth().toString() );
        tempSession.rollback();

    }

    @Test
    public void getAll() {
        final CustomerInfoDAO dao = tempTestSession.getMapper( CustomerInfoDAO.class );
        List<Customer_info> list = dao.getAll();
        list.stream().forEach( System.out::println );
        Assert.assertEquals( 15,list.size() );
    }

    @Test
    public void insertCustomer() throws ParseException {

        Customer_info custom = new Customer_info();
        custom.setGender( 1 );
        custom.setCustomer_name( "浪翻云" );
        custom.setDate_of_birth(new Date(System.currentTimeMillis()));
        custom.setCreate_time( new Timestamp(System.currentTimeMillis()));
        custom.setUpdate_time( new Timestamp(System.currentTimeMillis()));
        System.out.println(custom );
        SqlSession tempSession = sessionFactory.openSession();
        CustomerInfoDAO dao = tempSession.getMapper( CustomerInfoDAO.class );

        System.out.println(dao.insertCustomer(custom));
        System.out.println(custom.getCustomer_id());
        Assert.assertNotNull( custom.getCustomer_id() );
        tempSession.rollback();

    }

    @org.junit.Test
    public void updateCustomer() {

        Customer_info custom = new Customer_info();
        custom.setGender( 1 );
        custom.setCustomer_name( "浪翻云" );
        custom.setDate_of_birth(new Date(System.currentTimeMillis()));
        custom.setCreate_time( new Timestamp(System.currentTimeMillis()));
        custom.setUpdate_time( new Timestamp(System.currentTimeMillis()));
        System.out.println(custom );
        SqlSession tempSession = sessionFactory.openSession();
        CustomerInfoDAO dao = tempSession.getMapper( CustomerInfoDAO.class );
        System.out.println(dao.insertCustomer(custom));
        custom.setCustomer_name( "田伯光" );
        dao.updateCustomer( custom );
        System.out.println(custom );

        Customer_info newCustomer = dao.getCustomerById( custom.getCustomer_id().intValue() );
        System.out.println(newCustomer );
        Assert.assertEquals( newCustomer.getCustomer_name(),"田伯光" );
    }

    @org.junit.Test
    public void deleteCustomer() {

        Customer_info custom = new Customer_info();
        custom.setGender( 1 );
        custom.setCustomer_name( "浪翻云" );
        custom.setDate_of_birth(new Date(System.currentTimeMillis()));
        custom.setCreate_time( new Timestamp(System.currentTimeMillis()));
        custom.setUpdate_time( new Timestamp(System.currentTimeMillis()));
        System.out.println(custom );
        SqlSession tempSession = sessionFactory.openSession();
        CustomerInfoDAO dao = tempSession.getMapper( CustomerInfoDAO.class );
        System.out.println(dao.insertCustomer(custom));
        Assert.assertNotNull( custom.getCustomer_id() );

        System.out.println("existing record:" + dao.getCustomerById( custom.getCustomer_id().intValue() ) );

        int result = dao.deleteCustomer( custom.getCustomer_id().intValue() );
        System.out.println("record with id:" + custom.getCustomer_id() + " has been deleted" );
        Assert.assertEquals( 1, result);

        System.out.println("Searching customer with id is :" + custom.getCustomer_id() );
        Customer_info newCustomer = dao.getCustomerById( custom.getCustomer_id().intValue() );
        System.out.println("Result is :" + newCustomer);
        Assert.assertNull( newCustomer );

    }

    @org.junit.Test
    public void getAllCustomerMap() {

    }


}
