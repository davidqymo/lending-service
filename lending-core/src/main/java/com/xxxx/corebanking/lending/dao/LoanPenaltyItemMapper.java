package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanPenaltyItem;
import com.xxxx.corebanking.lending.entity.LoanPenaltyItemKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoanPenaltyItemMapper {
    @Delete({
            "delete from loan_penalty_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and calculation_end_date = #{calculationEndDate,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(LoanPenaltyItemKey key);

    @Insert({
            "insert into loan_penalty_info (loan_id, calculation_end_date, ",
            "last_interest_calculation_date, debit_interest-rate, ",
            "overdue_balance_for_interest_calculation, ",
            "overdue_interest_accruals, overdue_interest_collected, ",
            "create_time, update_time)",
            "values (#{loanId,jdbcType=BIGINT}, #{calculationEndDate,jdbcType=DATE}, ",
            "#{lastInterestCalculationDate,jdbcType=DATE}, #{debitInterestRate,jdbcType=DECIMAL}, ",
            "#{overdueBalanceForInterestCalculation,jdbcType=BIGINT}, ",
            "#{overdueInterestAccruals,jdbcType=BIGINT}, #{overdueInterestCollected,jdbcType=BIGINT}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(LoanPenaltyItem record);

    @InsertProvider(type = LoanPenaltyItemSqlProvider.class, method = "insertSelective")
    int insertSelective(LoanPenaltyItem record);

    @Select({
            "select",
            "loan_id, calculation_end_date, last_interest_calculation_date, debit_interest-rate, ",
            "overdue_balance_for_interest_calculation, overdue_interest_accruals, overdue_interest_collected, ",
            "create_time, update_time",
            "from loan_penalty_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and calculation_end_date = #{calculationEndDate,jdbcType=DATE}"
    })
    @Results({
            @Result(column = "loan_id", property = "loanId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "calculation_end_date", property = "calculationEndDate", jdbcType = JdbcType.DATE, id = true),
            @Result(column = "last_interest_calculation_date", property = "lastInterestCalculationDate", jdbcType = JdbcType.DATE),
            @Result(column = "debit_interest-rate", property = "debitInterestRate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "overdue_balance_for_interest_calculation", property = "overdueBalanceForInterestCalculation", jdbcType = JdbcType.BIGINT),
            @Result(column = "overdue_interest_accruals", property = "overdueInterestAccruals", jdbcType = JdbcType.BIGINT),
            @Result(column = "overdue_interest_collected", property = "overdueInterestCollected", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    LoanPenaltyItem selectByPrimaryKey(LoanPenaltyItemKey key);

    @UpdateProvider(type = LoanPenaltyItemSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanPenaltyItem record);

    @Update({
            "update loan_penalty_info",
            "set last_interest_calculation_date = #{lastInterestCalculationDate,jdbcType=DATE},",
            "debit_interest-rate = #{debitInterestRate,jdbcType=DECIMAL},",
            "overdue_balance_for_interest_calculation = #{overdueBalanceForInterestCalculation,jdbcType=BIGINT},",
            "overdue_interest_accruals = #{overdueInterestAccruals,jdbcType=BIGINT},",
            "overdue_interest_collected = #{overdueInterestCollected,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and calculation_end_date = #{calculationEndDate,jdbcType=DATE}"
    })
    int updateByPrimaryKey(LoanPenaltyItem record);
}
