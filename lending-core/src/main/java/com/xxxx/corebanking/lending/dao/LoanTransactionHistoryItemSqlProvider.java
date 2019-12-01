package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanTransactionHistoryItem;
import org.apache.ibatis.jdbc.SQL;

public class LoanTransactionHistoryItemSqlProvider {
    public String insertSelective(LoanTransactionHistoryItem record) {
        SQL sql = new SQL( );
        sql.INSERT_INTO( "loan_transaction_history" );

        if (record.getDealId( ) != null) {
            sql.VALUES( "deal_id", "#{dealId,jdbcType=BIGINT}" );
        }

        if (record.getTransactionDate( ) != null) {
            sql.VALUES( "transaction_date", "#{transactionDate,jdbcType=DATE}" );
        }

        if (record.getLoanId( ) != null) {
            sql.VALUES( "loan_id", "#{loanId,jdbcType=BIGINT}" );
        }

        if (record.getRepaymentAccountId( ) != null) {
            sql.VALUES( "repayment_account_id", "#{repaymentAccountId,jdbcType=BIGINT}" );
        }

        if (record.getCurrency( ) != null) {
            sql.VALUES( "currency", "#{currency,jdbcType=CHAR}" );
        }

        if (record.getTransactionAmout( ) != null) {
            sql.VALUES( "transaction_amout", "#{transactionAmout,jdbcType=BIGINT}" );
        }

        if (record.getLocalCurrencyTransactionAmount( ) != null) {
            sql.VALUES( "local_currency_transaction_amount", "#{localCurrencyTransactionAmount,jdbcType=BIGINT}" );
        }

        if (record.getExchangeRate( ) != null) {
            sql.VALUES( "exchange_rate", "#{exchangeRate,jdbcType=DECIMAL}" );
        }

        if (record.getNarrative( ) != null) {
            sql.VALUES( "narrative", "#{narrative,jdbcType=VARCHAR}" );
        }

        if (record.getPrincipalAmount( ) != null) {
            sql.VALUES( "principal_amount", "#{principalAmount,jdbcType=BIGINT}" );
        }

        if (record.getInterestAmount( ) != null) {
            sql.VALUES( "interest_amount", "#{interestAmount,jdbcType=BIGINT}" );
        }

        if (record.getOverduePenaltyAmount( ) != null) {
            sql.VALUES( "overdue_penalty_amount", "#{overduePenaltyAmount,jdbcType=BIGINT}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.VALUES( "create_time", "#{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.VALUES( "update_time", "#{updateTime,jdbcType=TIMESTAMP}" );
        }

        return sql.toString( );
    }

    public String updateByPrimaryKeySelective(LoanTransactionHistoryItem record) {
        SQL sql = new SQL( );
        sql.UPDATE( "loan_transaction_history" );

        if (record.getTransactionDate( ) != null) {
            sql.SET( "transaction_date = #{transactionDate,jdbcType=DATE}" );
        }

        if (record.getLoanId( ) != null) {
            sql.SET( "loan_id = #{loanId,jdbcType=BIGINT}" );
        }

        if (record.getRepaymentAccountId( ) != null) {
            sql.SET( "repayment_account_id = #{repaymentAccountId,jdbcType=BIGINT}" );
        }

        if (record.getCurrency( ) != null) {
            sql.SET( "currency = #{currency,jdbcType=CHAR}" );
        }

        if (record.getTransactionAmout( ) != null) {
            sql.SET( "transaction_amout = #{transactionAmout,jdbcType=BIGINT}" );
        }

        if (record.getLocalCurrencyTransactionAmount( ) != null) {
            sql.SET( "local_currency_transaction_amount = #{localCurrencyTransactionAmount,jdbcType=BIGINT}" );
        }

        if (record.getExchangeRate( ) != null) {
            sql.SET( "exchange_rate = #{exchangeRate,jdbcType=DECIMAL}" );
        }

        if (record.getNarrative( ) != null) {
            sql.SET( "narrative = #{narrative,jdbcType=VARCHAR}" );
        }

        if (record.getPrincipalAmount( ) != null) {
            sql.SET( "principal_amount = #{principalAmount,jdbcType=BIGINT}" );
        }

        if (record.getInterestAmount( ) != null) {
            sql.SET( "interest_amount = #{interestAmount,jdbcType=BIGINT}" );
        }

        if (record.getOverduePenaltyAmount( ) != null) {
            sql.SET( "overdue_penalty_amount = #{overduePenaltyAmount,jdbcType=BIGINT}" );
        }

        if (record.getCreateTime( ) != null) {
            sql.SET( "create_time = #{createTime,jdbcType=TIMESTAMP}" );
        }

        if (record.getUpdateTime( ) != null) {
            sql.SET( "update_time = #{updateTime,jdbcType=TIMESTAMP}" );
        }

        sql.WHERE( "deal_id = #{dealId,jdbcType=BIGINT}" );

        return sql.toString( );
    }
}
