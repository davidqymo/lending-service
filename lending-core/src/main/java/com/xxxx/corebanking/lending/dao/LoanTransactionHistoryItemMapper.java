package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanTransactionHistoryItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoanTransactionHistoryItemMapper {
    @Delete({
            "delete from loan_transaction_history",
            "where deal_id = #{dealId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long dealId);

    @Insert({
            "insert into loan_transaction_history (deal_id, transaction_date, ",
            "loan_id, repayment_account_id, ",
            "currency, transaction_amout, ",
            "local_currency_transaction_amount, exchange_rate, ",
            "narrative, principal_amount, ",
            "interest_amount, overdue_penalty_amount, ",
            "create_time, update_time)",
            "values (#{dealId,jdbcType=BIGINT}, #{transactionDate,jdbcType=DATE}, ",
            "#{loanId,jdbcType=BIGINT}, #{repaymentAccountId,jdbcType=BIGINT}, ",
            "#{currency,jdbcType=CHAR}, #{transactionAmout,jdbcType=BIGINT}, ",
            "#{localCurrencyTransactionAmount,jdbcType=BIGINT}, #{exchangeRate,jdbcType=DECIMAL}, ",
            "#{narrative,jdbcType=VARCHAR}, #{principalAmount,jdbcType=BIGINT}, ",
            "#{interestAmount,jdbcType=BIGINT}, #{overduePenaltyAmount,jdbcType=BIGINT}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(LoanTransactionHistoryItem record);

    @InsertProvider(type = LoanTransactionHistoryItemSqlProvider.class, method = "insertSelective")
    int insertSelective(LoanTransactionHistoryItem record);

    @Select({
            "select",
            "deal_id, transaction_date, loan_id, repayment_account_id, currency, transaction_amout, ",
            "local_currency_transaction_amount, exchange_rate, narrative, principal_amount, ",
            "interest_amount, overdue_penalty_amount, create_time, update_time",
            "from loan_transaction_history",
            "where deal_id = #{dealId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "deal_id", property = "dealId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "transaction_date", property = "transactionDate", jdbcType = JdbcType.DATE),
            @Result(column = "loan_id", property = "loanId", jdbcType = JdbcType.BIGINT),
            @Result(column = "repayment_account_id", property = "repaymentAccountId", jdbcType = JdbcType.BIGINT),
            @Result(column = "currency", property = "currency", jdbcType = JdbcType.CHAR),
            @Result(column = "transaction_amout", property = "transactionAmout", jdbcType = JdbcType.BIGINT),
            @Result(column = "local_currency_transaction_amount", property = "localCurrencyTransactionAmount", jdbcType = JdbcType.BIGINT),
            @Result(column = "exchange_rate", property = "exchangeRate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "narrative", property = "narrative", jdbcType = JdbcType.VARCHAR),
            @Result(column = "principal_amount", property = "principalAmount", jdbcType = JdbcType.BIGINT),
            @Result(column = "interest_amount", property = "interestAmount", jdbcType = JdbcType.BIGINT),
            @Result(column = "overdue_penalty_amount", property = "overduePenaltyAmount", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    LoanTransactionHistoryItem selectByPrimaryKey(Long dealId);

    @UpdateProvider(type = LoanTransactionHistoryItemSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanTransactionHistoryItem record);

    @Update({
            "update loan_transaction_history",
            "set transaction_date = #{transactionDate,jdbcType=DATE},",
            "loan_id = #{loanId,jdbcType=BIGINT},",
            "repayment_account_id = #{repaymentAccountId,jdbcType=BIGINT},",
            "currency = #{currency,jdbcType=CHAR},",
            "transaction_amout = #{transactionAmout,jdbcType=BIGINT},",
            "local_currency_transaction_amount = #{localCurrencyTransactionAmount,jdbcType=BIGINT},",
            "exchange_rate = #{exchangeRate,jdbcType=DECIMAL},",
            "narrative = #{narrative,jdbcType=VARCHAR},",
            "principal_amount = #{principalAmount,jdbcType=BIGINT},",
            "interest_amount = #{interestAmount,jdbcType=BIGINT},",
            "overdue_penalty_amount = #{overduePenaltyAmount,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where deal_id = #{dealId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanTransactionHistoryItem record);
}
