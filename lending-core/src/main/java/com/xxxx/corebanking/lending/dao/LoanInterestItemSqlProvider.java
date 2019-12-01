package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanInterestItem;
import org.apache.ibatis.jdbc.SQL;

public class LoanInterestItemSqlProvider {
    public String insertSelective(LoanInterestItem record) {
        SQL sql = new SQL( );
        sql.INSERT_INTO( "loan_interest_info" );

        if (record.getLoanId( ) != null) {
            sql.VALUES( "loan_id", "#{loanId,jdbcType=BIGINT}" );
        }

        if (record.getCalculationEndDate( ) != null) {
            sql.VALUES( "calculation_end_date", "#{calculationEndDate,jdbcType=DATE}" );
        }

        if (record.getLastInterestCalculationDate( ) != null) {
            sql.VALUES( "last_interest_calculation_date", "#{lastInterestCalculationDate,jdbcType=DATE}" );
        }

        if (record.getDebitInterestRate( ) != null) {
            sql.VALUES( "debit_interest-rate", "#{debitInterestRate,jdbcType=DECIMAL}" );
        }

        if (record.getBalanceForInterestCalculation( ) != null) {
            sql.VALUES( "balance_for_interest_calculation", "#{balanceForInterestCalculation,jdbcType=BIGINT}" );
        }

        if (record.getInterestAccruals( ) != null) {
            sql.VALUES( "interest_accruals", "#{interestAccruals,jdbcType=BIGINT}" );
        }

        if (record.getInterestCollected( ) != null) {
            sql.VALUES( "interest_collected", "#{interestCollected,jdbcType=BIGINT}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.VALUES( "create_time", "#{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.VALUES( "update_time", "#{updateTime,jdbcType=TIMESTAMP}" );
        }

        return sql.toString( );
    }

    public String updateByPrimaryKeySelective(LoanInterestItem record) {
        SQL sql = new SQL( );
        sql.UPDATE( "loan_interest_info" );

        if (record.getLastInterestCalculationDate( ) != null) {
            sql.SET( "last_interest_calculation_date = #{lastInterestCalculationDate,jdbcType=DATE}" );
        }

        if (record.getDebitInterestRate( ) != null) {
            sql.SET( "debit_interest-rate = #{debitInterestRate,jdbcType=DECIMAL}" );
        }

        if (record.getBalanceForInterestCalculation( ) != null) {
            sql.SET( "balance_for_interest_calculation = #{balanceForInterestCalculation,jdbcType=BIGINT}" );
        }

        if (record.getInterestAccruals( ) != null) {
            sql.SET( "interest_accruals = #{interestAccruals,jdbcType=BIGINT}" );
        }

        if (record.getInterestCollected( ) != null) {
            sql.SET( "interest_collected = #{interestCollected,jdbcType=BIGINT}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.SET( "create_time = #{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.SET( "update_time = #{updateTime,jdbcType=TIMESTAMP}" );
        }

        sql.WHERE( "loan_id = #{loanId,jdbcType=BIGINT}" );
        sql.WHERE( "calculation_end_date = #{calculationEndDate,jdbcType=DATE}" );

        return sql.toString( );
    }
}
