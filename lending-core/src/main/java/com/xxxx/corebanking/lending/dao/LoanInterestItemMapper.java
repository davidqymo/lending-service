package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanInterestItem;
import com.xxxx.corebanking.lending.entity.LoanInterestItemKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoanInterestItemMapper {
    @Delete({
            "delete from loan_interest_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and calculation_end_date = #{calculationEndDate,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(LoanInterestItemKey key);

    @Insert({
            "insert into loan_interest_info (loan_id, calculation_end_date, ",
            "last_interest_calculation_date, debit_interest-rate, ",
            "balance_for_interest_calculation, interest_accruals, ",
            "interest_collected, create_time, ",
            "update_time)",
            "values (#{loanId,jdbcType=BIGINT}, #{calculationEndDate,jdbcType=DATE}, ",
            "#{lastInterestCalculationDate,jdbcType=DATE}, #{debitInterestRate,jdbcType=DECIMAL}, ",
            "#{balanceForInterestCalculation,jdbcType=BIGINT}, #{interestAccruals,jdbcType=BIGINT}, ",
            "#{interestCollected,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(LoanInterestItem record);

    @InsertProvider(type = LoanInterestItemSqlProvider.class, method = "insertSelective")
    int insertSelective(LoanInterestItem record);

    @Select({
            "select",
            "loan_id, calculation_end_date, last_interest_calculation_date, debit_interest-rate, ",
            "balance_for_interest_calculation, interest_accruals, interest_collected, create_time, ",
            "update_time",
            "from loan_interest_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and calculation_end_date = #{calculationEndDate,jdbcType=DATE}"
    })
    @Results({
            @Result(column = "loan_id", property = "loanId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "calculation_end_date", property = "calculationEndDate", jdbcType = JdbcType.DATE, id = true),
            @Result(column = "last_interest_calculation_date", property = "lastInterestCalculationDate", jdbcType = JdbcType.DATE),
            @Result(column = "debit_interest-rate", property = "debitInterestRate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "balance_for_interest_calculation", property = "balanceForInterestCalculation", jdbcType = JdbcType.BIGINT),
            @Result(column = "interest_accruals", property = "interestAccruals", jdbcType = JdbcType.BIGINT),
            @Result(column = "interest_collected", property = "interestCollected", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    LoanInterestItem selectByPrimaryKey(LoanInterestItemKey key);

    @UpdateProvider(type = LoanInterestItemSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanInterestItem record);

    @Update({
            "update loan_interest_info",
            "set last_interest_calculation_date = #{lastInterestCalculationDate,jdbcType=DATE},",
            "debit_interest-rate = #{debitInterestRate,jdbcType=DECIMAL},",
            "balance_for_interest_calculation = #{balanceForInterestCalculation,jdbcType=BIGINT},",
            "interest_accruals = #{interestAccruals,jdbcType=BIGINT},",
            "interest_collected = #{interestCollected,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and calculation_end_date = #{calculationEndDate,jdbcType=DATE}"
    })
    int updateByPrimaryKey(LoanInterestItem record);
}
