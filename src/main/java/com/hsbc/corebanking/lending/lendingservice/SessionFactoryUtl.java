package com.hsbc.corebanking.lending.lendingservice;
import java.io.IOException;
import	java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryUtl {

    public static SqlSessionFactory  getInstance() throws IOException {
        String resource = "MyBatis_Config.xml";
        InputStream inputStream = Resources.getResourceAsStream( resource);
        SqlSessionFactory result = new SqlSessionFactoryBuilder().build( inputStream );
        return result;
    }

    public static SqlSession getSqlSession() throws IOException {
        SqlSessionFactory factory = getInstance();
        SqlSession session = factory.openSession();
        return session;
    }
}
