package com.xxxx.corebanking.lending.lendingservice;
import java.io.IOException;
import	java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryUtl {

    /**
     * Create SqlSessionFactory - factory class for generate the sqlsession
     *  - input from the MyBatis configuration xml file
     *
     * @return SqlSessionFactory
     * @throws IOException
     */
    public static SqlSessionFactory  getInstance() throws IOException {
        String resource = "MyBatis_Config.xml";
        InputStream inputStream = Resources.getResourceAsStream( resource);
        SqlSessionFactory result = new SqlSessionFactoryBuilder().build( inputStream );
        return result;
    }

    /**
     * create the SqlSession.
     * Sql Session is key object to look for the id of SQL statement, then execute it.
     *
     *
     * @return
     * @throws IOException
     */
    public static SqlSession getSqlSession() throws IOException {
        SqlSessionFactory factory = getInstance();
        SqlSession session = factory.openSession();
        return session;
    }
}
