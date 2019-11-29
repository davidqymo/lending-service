package com.xxxx.corebanking.lending.lendingservice;
import java.io.IOException;
import	java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    @Bean("sqlSessionFactory")
    SqlSessionFactory getMySessionFactory() throws IOException {
        String resource = "MyBatis_Config.xml";
        InputStream inputStream = Resources.getResourceAsStream( resource);
        SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build( inputStream );
        return sqlSession;
    }
@Bean("mybatisSession")
SqlSession getMySqlSession() throws IOException {
        SqlSessionFactory sqlfactory = getMySessionFactory();
        return sqlfactory.openSession();
}

}
