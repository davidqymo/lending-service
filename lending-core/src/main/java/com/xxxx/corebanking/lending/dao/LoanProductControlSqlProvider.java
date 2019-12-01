package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanProductControl;
import org.apache.ibatis.jdbc.SQL;

public class LoanProductControlSqlProvider {
    public String insertSelective(LoanProductControl record) {
        SQL sql = new SQL( );
        sql.INSERT_INTO( "loan_product_control" );

        if (record.getProductId( ) != null) {
            sql.VALUES( "product_id", "#{productId,jdbcType=CHAR}" );
        }

        if (record.getProductDescription( ) != null) {
            sql.VALUES( "product_description", "#{productDescription,jdbcType=CHAR}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.VALUES( "create_time", "#{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.VALUES( "update_time", "#{updateTime,jdbcType=TIMESTAMP}" );
        }

        return sql.toString( );
    }

    public String updateByPrimaryKeySelective(LoanProductControl record) {
        SQL sql = new SQL( );
        sql.UPDATE( "loan_product_control" );

        if (record.getProductDescription( ) != null) {
            sql.SET( "product_description = #{productDescription,jdbcType=CHAR}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.SET( "create_time = #{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.SET( "update_time = #{updateTime,jdbcType=TIMESTAMP}" );
        }

        sql.WHERE( "product_id = #{productId,jdbcType=CHAR}" );

        return sql.toString( );
    }
}
