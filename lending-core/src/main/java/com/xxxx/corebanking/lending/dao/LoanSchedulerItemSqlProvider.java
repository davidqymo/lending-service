package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanSchedulerItem;
import org.apache.ibatis.jdbc.SQL;

public class LoanSchedulerItemSqlProvider {
    public String insertSelective(LoanSchedulerItem record) {
        SQL sql = new SQL( );
        sql.INSERT_INTO( "loan_scheduler_info" );

        if (record.getLoanId( ) != null) {
            sql.VALUES( "loan_id", "#{loanId,jdbcType=BIGINT}" );
        }

        if (record.getStartDate( ) != null) {
            sql.VALUES( "start_date", "#{startDate,jdbcType=DATE}" );
        }

        if (record.getRepaymentScheme( ) != null) {
            sql.VALUES( "repayment_scheme", "#{repaymentScheme,jdbcType=CHAR}" );
        }

        if (record.getDebitInterestRate( ) != null) {
            sql.VALUES( "debit_interest_rate", "#{debitInterestRate,jdbcType=DECIMAL}" );
        }

        if (record.getNextInstalmentDate( ) != null) {
            sql.VALUES( "next_instalment_date", "#{nextInstalmentDate,jdbcType=DATE}" );
        }

        if (record.getNextInstalmentAmount( ) != null) {
            sql.VALUES( "next_instalment_amount", "#{nextInstalmentAmount,jdbcType=BIGINT}" );
        }

        if (record.getNextInterestApplicationDate( ) != null) {
            sql.VALUES( "next_interest_application_date", "#{nextInterestApplicationDate,jdbcType=DATE}" );
        }

        if (record.getInstalmentFrequency( ) != null) {
            sql.VALUES( "instalment_frequency", "#{instalmentFrequency,jdbcType=CHAR}" );
        }

        if (record.getInterestApplicationFrequency( ) != null) {
            sql.VALUES( "interest_application_frequency", "#{interestApplicationFrequency,jdbcType=CHAR}" );
        }

        if (record.getNextInterestReviewDate( ) != null) {
            sql.VALUES( "next_interest_review_date", "#{nextInterestReviewDate,jdbcType=DATE}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.VALUES( "create_time", "#{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.VALUES( "update_time", "#{updateTime,jdbcType=TIMESTAMP}" );
        }

        return sql.toString( );
    }

    public String updateByPrimaryKeySelective(LoanSchedulerItem record) {
        SQL sql = new SQL( );
        sql.UPDATE( "loan_scheduler_info" );

        if (record.getRepaymentScheme( ) != null) {
            sql.SET( "repayment_scheme = #{repaymentScheme,jdbcType=CHAR}" );
        }

        if (record.getDebitInterestRate( ) != null) {
            sql.SET( "debit_interest_rate = #{debitInterestRate,jdbcType=DECIMAL}" );
        }

        if (record.getNextInstalmentDate( ) != null) {
            sql.SET( "next_instalment_date = #{nextInstalmentDate,jdbcType=DATE}" );
        }

        if (record.getNextInstalmentAmount( ) != null) {
            sql.SET( "next_instalment_amount = #{nextInstalmentAmount,jdbcType=BIGINT}" );
        }

        if (record.getNextInterestApplicationDate( ) != null) {
            sql.SET( "next_interest_application_date = #{nextInterestApplicationDate,jdbcType=DATE}" );
        }

        if (record.getInstalmentFrequency( ) != null) {
            sql.SET( "instalment_frequency = #{instalmentFrequency,jdbcType=CHAR}" );
        }

        if (record.getInterestApplicationFrequency( ) != null) {
            sql.SET( "interest_application_frequency = #{interestApplicationFrequency,jdbcType=CHAR}" );
        }

        if (record.getNextInterestReviewDate( ) != null) {
            sql.SET( "next_interest_review_date = #{nextInterestReviewDate,jdbcType=DATE}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.SET( "create_time = #{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.SET( "update_time = #{updateTime,jdbcType=TIMESTAMP}" );
        }

        sql.WHERE( "loan_id = #{loanId,jdbcType=BIGINT}" );
        sql.WHERE( "start_date = #{startDate,jdbcType=DATE}" );

        return sql.toString( );
    }
}
