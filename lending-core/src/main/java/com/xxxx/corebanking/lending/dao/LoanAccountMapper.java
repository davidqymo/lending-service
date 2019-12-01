package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoanAccountMapper {
    @Delete({
            "delete from loan_account_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long loanId);

    @Insert({
            "insert into loan_account_info (customer_id, limit_id, ",
            "product_id, currency, status, ",
            "open_date, due_date, balance, ",
            "loan_term, loan_term_unit, ",
            "create_time, update_time)",
            "values (#{customerId,jdbcType=BIGINT}, #{limitId,jdbcType=BIGINT}, ",
            "#{productId,jdbcType=CHAR}, #{currency,jdbcType=CHAR}, #{status,jdbcType=BIT}, ",
            "#{openDate,jdbcType=DATE}, #{dueDate,jdbcType=DATE}, #{balance,jdbcType=BIGINT}, ",
            "#{loanTerm,jdbcType=INTEGER}, #{loanTermUnit,jdbcType=CHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "loanId", before = false, resultType = Long.class)
    int insert(LoanAccount record);

    @InsertProvider(type = LoanAccountSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "loanId", before = false, resultType = Long.class)
    int insertSelective(LoanAccount record);

    @Select({
            "select",
            "loan_id, customer_id, limit_id, product_id, currency, status, open_date, due_date, ",
            "balance, loan_term, loan_term_unit, create_time, update_time",
            "from loan_account_info",
            "where loan_id = #{loanId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "loan_id", property = "loanId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "customer_id", property = "customerId", jdbcType = JdbcType.BIGINT),
            @Result(column = "limit_id", property = "limitId", jdbcType = JdbcType.BIGINT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.CHAR),
            @Result(column = "currency", property = "currency", jdbcType = JdbcType.CHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "open_date", property = "openDate", jdbcType = JdbcType.DATE),
            @Result(column = "due_date", property = "dueDate", jdbcType = JdbcType.DATE),
            @Result(column = "balance", property = "balance", jdbcType = JdbcType.BIGINT),
            @Result(column = "loan_term", property = "loanTerm", jdbcType = JdbcType.INTEGER),
            @Result(column = "loan_term_unit", property = "loanTermUnit", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    LoanAccount selectByPrimaryKey(Long loanId);

    @UpdateProvider(type = LoanAccountSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanAccount record);

    @Update({
            "update loan_account_info",
            "set customer_id = #{customerId,jdbcType=BIGINT},",
            "limit_id = #{limitId,jdbcType=BIGINT},",
            "product_id = #{productId,jdbcType=CHAR},",
            "currency = #{currency,jdbcType=CHAR},",
            "status = #{status,jdbcType=BIT},",
            "open_date = #{openDate,jdbcType=DATE},",
            "due_date = #{dueDate,jdbcType=DATE},",
            "balance = #{balance,jdbcType=BIGINT},",
            "loan_term = #{loanTerm,jdbcType=INTEGER},",
            "loan_term_unit = #{loanTermUnit,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where loan_id = #{loanId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanAccount record);
}
