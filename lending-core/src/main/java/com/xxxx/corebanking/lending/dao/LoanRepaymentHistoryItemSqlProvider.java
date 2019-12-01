package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanRepaymentHistoryItem;
import org.apache.ibatis.jdbc.SQL;

public class LoanRepaymentHistoryItemSqlProvider {
    public String insertSelective(LoanRepaymentHistoryItem record) {
        SQL sql = new SQL( );
        sql.INSERT_INTO( "loan_repayment_history" );

        if (record.getLoanId( ) != null) {
            sql.VALUES( "loan_id", "#{loanId,jdbcType=BIGINT}" );
        }

        if (record.getInstalmentDueDate( ) != null) {
            sql.VALUES( "instalment_due_date", "#{instalmentDueDate,jdbcType=DATE}" );
        }

        if (record.getInstalmentAmount( ) != null) {
            sql.VALUES( "instalment_amount", "#{instalmentAmount,jdbcType=BIGINT}" );
        }

        if (record.getInstalmentAmountPaid( ) != null) {
            sql.VALUES( "instalment_amount_paid", "#{instalmentAmountPaid,jdbcType=BIGINT}" );
        }

        if (record.getPrincipalPortion( ) != null) {
            sql.VALUES( "principal_portion", "#{principalPortion,jdbcType=BIGINT}" );
        }

        if (record.getInterstPortion( ) != null) {
            sql.VALUES( "interst_portion", "#{interstPortion,jdbcType=BIGINT}" );
        }

        if (record.getPrincipalPortionPaid( ) != null) {
            sql.VALUES( "principal_portion_paid", "#{principalPortionPaid,jdbcType=BIGINT}" );
        }

        if (record.getInterstPortionPaid( ) != null) {
            sql.VALUES( "interst_portion_paid", "#{interstPortionPaid,jdbcType=BIGINT}" );
        }

        if (record.getInstalmentStatus( ) != null) {
            sql.VALUES( "instalment_status", "#{instalmentStatus,jdbcType=CHAR}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.VALUES( "create_time", "#{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.VALUES( "update_time", "#{updateTime,jdbcType=TIMESTAMP}" );
        }

        return sql.toString( );
    }

    public String updateByPrimaryKeySelective(LoanRepaymentHistoryItem record) {
        SQL sql = new SQL( );
        sql.UPDATE( "loan_repayment_history" );

        if (record.getInstalmentAmount( ) != null) {
            sql.SET( "instalment_amount = #{instalmentAmount,jdbcType=BIGINT}" );
        }

        if (record.getInstalmentAmountPaid( ) != null) {
            sql.SET( "instalment_amount_paid = #{instalmentAmountPaid,jdbcType=BIGINT}" );
        }

        if (record.getPrincipalPortion( ) != null) {
            sql.SET( "principal_portion = #{principalPortion,jdbcType=BIGINT}" );
        }

        if (record.getInterstPortion( ) != null) {
            sql.SET( "interst_portion = #{interstPortion,jdbcType=BIGINT}" );
        }

        if (record.getPrincipalPortionPaid( ) != null) {
            sql.SET( "principal_portion_paid = #{principalPortionPaid,jdbcType=BIGINT}" );
        }

        if (record.getInterstPortionPaid( ) != null) {
            sql.SET( "interst_portion_paid = #{interstPortionPaid,jdbcType=BIGINT}" );
        }

        if (record.getInstalmentStatus( ) != null) {
            sql.SET( "instalment_status = #{instalmentStatus,jdbcType=CHAR}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.SET( "create_time = #{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.SET( "update_time = #{updateTime,jdbcType=TIMESTAMP}" );
        }

        sql.WHERE( "loan_id = #{loanId,jdbcType=BIGINT}" );
        sql.WHERE( "instalment_due_date = #{instalmentDueDate,jdbcType=DATE}" );

        return sql.toString( );
    }
}
