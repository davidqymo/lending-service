package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanRepaymentHistoryItem;
import com.xxxx.corebanking.lending.entity.LoanRepaymentHistoryItemKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoanRepaymentHistoryItemMapper {
    @Delete({
            "delete from loan_repayment_history",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and instalment_due_date = #{instalmentDueDate,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(LoanRepaymentHistoryItemKey key);

    @Insert({
            "insert into loan_repayment_history (loan_id, instalment_due_date, ",
            "instalment_amount, instalment_amount_paid, ",
            "principal_portion, interst_portion, ",
            "principal_portion_paid, interst_portion_paid, ",
            "instalment_status, create_time, ",
            "update_time)",
            "values (#{loanId,jdbcType=BIGINT}, #{instalmentDueDate,jdbcType=DATE}, ",
            "#{instalmentAmount,jdbcType=BIGINT}, #{instalmentAmountPaid,jdbcType=BIGINT}, ",
            "#{principalPortion,jdbcType=BIGINT}, #{interstPortion,jdbcType=BIGINT}, ",
            "#{principalPortionPaid,jdbcType=BIGINT}, #{interstPortionPaid,jdbcType=BIGINT}, ",
            "#{instalmentStatus,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(LoanRepaymentHistoryItem record);

    @InsertProvider(type = LoanRepaymentHistoryItemSqlProvider.class, method = "insertSelective")
    int insertSelective(LoanRepaymentHistoryItem record);

    @Select({
            "select",
            "loan_id, instalment_due_date, instalment_amount, instalment_amount_paid, principal_portion, ",
            "interst_portion, principal_portion_paid, interst_portion_paid, instalment_status, ",
            "create_time, update_time",
            "from loan_repayment_history",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and instalment_due_date = #{instalmentDueDate,jdbcType=DATE}"
    })
    @Results({
            @Result(column = "loan_id", property = "loanId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "instalment_due_date", property = "instalmentDueDate", jdbcType = JdbcType.DATE, id = true),
            @Result(column = "instalment_amount", property = "instalmentAmount", jdbcType = JdbcType.BIGINT),
            @Result(column = "instalment_amount_paid", property = "instalmentAmountPaid", jdbcType = JdbcType.BIGINT),
            @Result(column = "principal_portion", property = "principalPortion", jdbcType = JdbcType.BIGINT),
            @Result(column = "interst_portion", property = "interstPortion", jdbcType = JdbcType.BIGINT),
            @Result(column = "principal_portion_paid", property = "principalPortionPaid", jdbcType = JdbcType.BIGINT),
            @Result(column = "interst_portion_paid", property = "interstPortionPaid", jdbcType = JdbcType.BIGINT),
            @Result(column = "instalment_status", property = "instalmentStatus", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    LoanRepaymentHistoryItem selectByPrimaryKey(LoanRepaymentHistoryItemKey key);

    @UpdateProvider(type = LoanRepaymentHistoryItemSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanRepaymentHistoryItem record);

    @Update({
            "update loan_repayment_history",
            "set instalment_amount = #{instalmentAmount,jdbcType=BIGINT},",
            "instalment_amount_paid = #{instalmentAmountPaid,jdbcType=BIGINT},",
            "principal_portion = #{principalPortion,jdbcType=BIGINT},",
            "interst_portion = #{interstPortion,jdbcType=BIGINT},",
            "principal_portion_paid = #{principalPortionPaid,jdbcType=BIGINT},",
            "interst_portion_paid = #{interstPortionPaid,jdbcType=BIGINT},",
            "instalment_status = #{instalmentStatus,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where loan_id = #{loanId,jdbcType=BIGINT}",
            "and instalment_due_date = #{instalmentDueDate,jdbcType=DATE}"
    })
    int updateByPrimaryKey(LoanRepaymentHistoryItem record);
}
