package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanSchedulerItem;
import com.xxxx.corebanking.lending.entity.LoanSchedulerItemKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoanSchedulerItemMapper {
    @Delete({
            "delete from loan_scheduler_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and start_date = #{startDate,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(LoanSchedulerItemKey key);

    @Insert({
            "insert into loan_scheduler_info (loan_id, start_date, ",
            "repayment_scheme, debit_interest_rate, ",
            "next_instalment_date, next_instalment_amount, ",
            "next_interest_application_date, instalment_frequency, ",
            "interest_application_frequency, next_interest_review_date, ",
            "create_time, update_time)",
            "values (#{loanId,jdbcType=BIGINT}, #{startDate,jdbcType=DATE}, ",
            "#{repaymentScheme,jdbcType=CHAR}, #{debitInterestRate,jdbcType=DECIMAL}, ",
            "#{nextInstalmentDate,jdbcType=DATE}, #{nextInstalmentAmount,jdbcType=BIGINT}, ",
            "#{nextInterestApplicationDate,jdbcType=DATE}, #{instalmentFrequency,jdbcType=CHAR}, ",
            "#{interestApplicationFrequency,jdbcType=CHAR}, #{nextInterestReviewDate,jdbcType=DATE}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(LoanSchedulerItem record);

    @InsertProvider(type = LoanSchedulerItemSqlProvider.class, method = "insertSelective")
    int insertSelective(LoanSchedulerItem record);

    @Select({
            "select",
            "loan_id, start_date, repayment_scheme, debit_interest_rate, next_instalment_date, ",
            "next_instalment_amount, next_interest_application_date, instalment_frequency, ",
            "interest_application_frequency, next_interest_review_date, create_time, update_time",
            "from loan_scheduler_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and start_date = #{startDate,jdbcType=DATE}"
    })
    @Results({
            @Result(column = "loan_id", property = "loanId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "start_date", property = "startDate", jdbcType = JdbcType.DATE, id = true),
            @Result(column = "repayment_scheme", property = "repaymentScheme", jdbcType = JdbcType.CHAR),
            @Result(column = "debit_interest_rate", property = "debitInterestRate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "next_instalment_date", property = "nextInstalmentDate", jdbcType = JdbcType.DATE),
            @Result(column = "next_instalment_amount", property = "nextInstalmentAmount", jdbcType = JdbcType.BIGINT),
            @Result(column = "next_interest_application_date", property = "nextInterestApplicationDate", jdbcType = JdbcType.DATE),
            @Result(column = "instalment_frequency", property = "instalmentFrequency", jdbcType = JdbcType.CHAR),
            @Result(column = "interest_application_frequency", property = "interestApplicationFrequency", jdbcType = JdbcType.CHAR),
            @Result(column = "next_interest_review_date", property = "nextInterestReviewDate", jdbcType = JdbcType.DATE),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    LoanSchedulerItem selectByPrimaryKey(LoanSchedulerItemKey key);

    @UpdateProvider(type = LoanSchedulerItemSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanSchedulerItem record);

    @Update({
            "update loan_scheduler_info",
            "set repayment_scheme = #{repaymentScheme,jdbcType=CHAR},",
            "debit_interest_rate = #{debitInterestRate,jdbcType=DECIMAL},",
            "next_instalment_date = #{nextInstalmentDate,jdbcType=DATE},",
            "next_instalment_amount = #{nextInstalmentAmount,jdbcType=BIGINT},",
            "next_interest_application_date = #{nextInterestApplicationDate,jdbcType=DATE},",
            "instalment_frequency = #{instalmentFrequency,jdbcType=CHAR},",
            "interest_application_frequency = #{interestApplicationFrequency,jdbcType=CHAR},",
            "next_interest_review_date = #{nextInterestReviewDate,jdbcType=DATE},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and start_date = #{startDate,jdbcType=DATE}"
    })
    int updateByPrimaryKey(LoanSchedulerItem record);
}
