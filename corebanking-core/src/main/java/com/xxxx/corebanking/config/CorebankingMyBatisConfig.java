package com.xxxx.corebanking.config;
import java.io.IOException;
import java.io.InputStream;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Component
@MapperScan("com.xxxx.corebanking.dao")
@EnableTransactionManagement
public class CorebankingMyBatisConfig {

    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean( );
//        bean.setDataSource( getDataSource() );
        bean.setDataSource( dataSource( ) );
        return bean.getObject( );
    }


    //    @Bean
//    HikariDataSource getDataSource() {
//        HikariDataSource ds = new HikariDataSource(  );
////        ds.setUsername( "root" );
////        ds.setPassword( "root" );
////        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
////        ds.setJdbcUrl( "jdbc:mysql://localhost:3306/smart_lending?serverTimezone=Hongkong&characterEncoding=utf8" );
//        ds.setDataSource( dataSource() );
//        ds.setMaximumPoolSize( 50 );
//        ds.setPoolName( "lending-pool5" );
//        return ds;
//    }esource("classpath:c

    @Bean
    SimpleDriverDataSource dataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource( );
        ds.setUsername( "root" );
        ds.setPassword( "root" );
        ds.setUrl( "jdbc:mysql://localhost:3306/smart_lending?serverTimezone=Hongkong&characterEncoding=utf8" );
        ds.setDriverClass( com.mysql.cj.jdbc.Driver.class );
        return ds;
    }


    @Bean("transactionManager")
    DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dsm = new DataSourceTransactionManager( );
//        dsm.setDataSource( getDataSource() );
        dsm.setDataSource( dataSource( ) );
        return dsm;
    }

}
