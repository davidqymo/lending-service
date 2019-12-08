package com.xxxx.corebanking.lending.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class LendingMyBatisConfig {

    @Bean("lendingSqlSessionFactory")
    SqlSessionFactory getMySessionFactory() throws IOException {
        String resource = "MyBatis.Config.xml";
        InputStream inputStream = Resources.getResourceAsStream( resource );
        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder( ).build( inputStream );
        return sqlSession;
    }

    @Bean("lendingMybatisSession")
    SqlSession getMySqlSession() throws IOException {
        SqlSessionFactory sqlfactory = getMySessionFactory( );
        SqlSession session = sqlfactory.openSession( true );
        return session;
    }


}
