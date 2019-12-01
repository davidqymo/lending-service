package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanPenaltyItem;
import org.apache.ibatis.jdbc.SQL;

public class LoanPenaltyItemSqlProvider {
    public String insertSelective(LoanPenaltyItem record) {
        SQL sql = new SQL( );
        sql.INSERT_INTO( "loan_penalty_info" );

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

        if (record.getOverdueBalanceForInterestCalculation( ) != null) {
            sql.VALUES( "overdue_balance_for_interest_calculation", "#{overdueBalanceForInterestCalculation,jdbcType=BIGINT}" );
        }

        if (record.getOverdueInterestAccruals( ) != null) {
            sql.VALUES( "overdue_interest_accruals", "#{overdueInterestAccruals,jdbcType=BIGINT}" );
        }

        if (record.getOverdueInterestCollected( ) != null) {
            sql.VALUES( "overdue_interest_collected", "#{overdueInterestCollected,jdbcType=BIGINT}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.VALUES( "create_time", "#{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.VALUES( "update_time", "#{updateTime,jdbcType=TIMESTAMP}" );
        }

        return sql.toString( );
    }

    public String updateByPrimaryKeySelective(LoanPenaltyItem record) {
        SQL sql = new SQL( );
        sql.UPDATE( "loan_penalty_info" );

        if (record.getLastInterestCalculationDate( ) != null) {
            sql.SET( "last_interest_calculation_date = #{lastInterestCalculationDate,jdbcType=DATE}" );
        }

        if (record.getDebitInterestRate( ) != null) {
            sql.SET( "debit_interest-rate = #{debitInterestRate,jdbcType=DECIMAL}" );
        }

        if (record.getOverdueBalanceForInterestCalculation( ) != null) {
            sql.SET( "overdue_balance_for_interest_calculation = #{overdueBalanceForInterestCalculation,jdbcType=BIGINT}" );
        }

        if (record.getOverdueInterestAccruals( ) != null) {
            sql.SET( "overdue_interest_accruals = #{overdueInterestAccruals,jdbcType=BIGINT}" );
        }

        if (record.getOverdueInterestCollected( ) != null) {
            sql.SET( "overdue_interest_collected = #{overdueInterestCollected,jdbcType=BIGINT}" );
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
