package com.xxxx.corebanking;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName( "com.mysql.cj.jdbc.Driver" );  //load the driver

        Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/smart_lending?serverTimezone=UTC&characterEncoding=utf8", "root", "root" );

        PreparedStatement ps = connection.prepareStatement( "Select * from customer_info" );

        ResultSet rs = ps.executeQuery( );

        Long id = 0L;
        String customerName = null;

        if (rs.next( )) {
            id = rs.getLong( "customer_id" );
            customerName = rs.getString( "customer_name" );
        }

        System.out.println( "customer id is :" + id + " CustomerName :" + customerName );

        rs.close( );
        connection.close( );

    }
}
