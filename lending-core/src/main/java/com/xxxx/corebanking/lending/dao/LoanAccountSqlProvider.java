package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanAccount;
import org.apache.ibatis.jdbc.SQL;

public class LoanAccountSqlProvider {
    public String insertSelective(LoanAccount record) {
        SQL sql = new SQL( );
        sql.INSERT_INTO( "loan_account_info" );

        if (record.getCustomerId( ) != null) {
            sql.VALUES( "customer_id", "#{customerId,jdbcType=BIGINT}" );
        }

        if (record.getLimitId( ) != null) {
            sql.VALUES( "limit_id", "#{limitId,jdbcType=BIGINT}" );
        }

        if (record.getProductId( ) != null) {
            sql.VALUES( "product_id", "#{productId,jdbcType=CHAR}" );
        }

        if (record.getCurrency( ) != null) {
            sql.VALUES( "currency", "#{currency,jdbcType=CHAR}" );
        }

        if (record.getStatus( ) != null) {
            sql.VALUES( "status", "#{status,jdbcType=BIT}" );
        }

        if (record.getOpenDate( ) != null) {
            sql.VALUES( "open_date", "#{openDate,jdbcType=DATE}" );
        }

        if (record.getDueDate( ) != null) {
            sql.VALUES( "due_date", "#{dueDate,jdbcType=DATE}" );
        }

        if (record.getBalance( ) != null) {
            sql.VALUES( "balance", "#{balance,jdbcType=BIGINT}" );
        }

        if (record.getLoanTerm( ) != null) {
            sql.VALUES( "loan_term", "#{loanTerm,jdbcType=INTEGER}" );
        }

        if (record.getLoanTermUnit( ) != null) {
            sql.VALUES( "loan_term_unit", "#{loanTermUnit,jdbcType=CHAR}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.VALUES( "create_time", "#{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.VALUES( "update_time", "#{updateTime,jdbcType=TIMESTAMP}" );
        }

        return sql.toString( );
    }

    public String updateByPrimaryKeySelective(LoanAccount record) {
        SQL sql = new SQL( );
        sql.UPDATE( "loan_account_info" );

        if (record.getCustomerId( ) != null) {
            sql.SET( "customer_id = #{customerId,jdbcType=BIGINT}" );
        }

        if (record.getLimitId( ) != null) {
            sql.SET( "limit_id = #{limitId,jdbcType=BIGINT}" );
        }

        if (record.getProductId( ) != null) {
            sql.SET( "product_id = #{productId,jdbcType=CHAR}" );
        }

        if (record.getCurrency( ) != null) {
            sql.SET( "currency = #{currency,jdbcType=CHAR}" );
        }

        if (record.getStatus( ) != null) {
            sql.SET( "status = #{status,jdbcType=BIT}" );
        }

        if (record.getOpenDate( ) != null) {
            sql.SET( "open_date = #{openDate,jdbcType=DATE}" );
        }

        if (record.getDueDate( ) != null) {
            sql.SET( "due_date = #{dueDate,jdbcType=DATE}" );
        }

        if (record.getBalance( ) != null) {
            sql.SET( "balance = #{balance,jdbcType=BIGINT}" );
        }

        if (record.getLoanTerm( ) != null) {
            sql.SET( "loan_term = #{loanTerm,jdbcType=INTEGER}" );
        }

        if (record.getLoanTermUnit( ) != null) {
            sql.SET( "loan_term_unit = #{loanTermUnit,jdbcType=CHAR}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.SET( "create_time = #{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.SET( "update_time = #{updateTime,jdbcType=TIMESTAMP}" );
        }

        sql.WHERE( "loan_id = #{loanId,jdbcType=BIGINT}" );

        return sql.toString( );
    }
}
