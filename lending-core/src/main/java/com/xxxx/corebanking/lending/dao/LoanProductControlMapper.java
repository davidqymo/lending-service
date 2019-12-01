package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanProductControl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LoanProductControlMapper {
    @Delete({
            "delete from loan_product_control",
            "where product_id = #{productId,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String productId);

    @Insert({
            "insert into loan_product_control (product_id, product_description, ",
            "create_time, update_time)",
            "values (#{productId,jdbcType=CHAR}, #{productDescription,jdbcType=CHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(LoanProductControl record);

    @InsertProvider(type = LoanProductControlSqlProvider.class, method = "insertSelective")
    int insertSelective(LoanProductControl record);

    @Select({
            "select",
            "product_id, product_description, create_time, update_time",
            "from loan_product_control",
            "where product_id = #{productId,jdbcType=CHAR}"
    })
    @Results({
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.CHAR, id = true),
            @Result(column = "product_description", property = "productDescription", jdbcType = JdbcType.CHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    LoanProductControl selectByPrimaryKey(String productId);

    @UpdateProvider(type = LoanProductControlSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LoanProductControl record);

    @Update({
            "update loan_product_control",
            "set product_description = #{productDescription,jdbcType=CHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where product_id = #{productId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(LoanProductControl record);
}
