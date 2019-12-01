package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.Customer;
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

public interface CustomerMapper {
    @Delete({
        "delete from customer_info",
        "where customer_id = #{customerId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long customerId);

    @Insert({
        "insert into customer_info (customer_name, gender, ",
        "date_of_birth, create_time, ",
        "update_time)",
        "values (#{customerName,jdbcType=VARCHAR}, #{gender,jdbcType=BIT}, ",
        "#{dateOfBirth,jdbcType=DATE}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="customerId", before=false, resultType=Long.class)
    int insert(Customer record);

    @InsertProvider(type=CustomerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="customerId", before=false, resultType=Long.class)
    int insertSelective(Customer record);

    @Select({
        "select",
        "customer_id, customer_name, gender, date_of_birth, create_time, update_time",
        "from customer_info",
        "where customer_id = #{customerId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.BIT),
        @Result(column="date_of_birth", property="dateOfBirth", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Customer selectByPrimaryKey(Long customerId);

    @UpdateProvider(type=CustomerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Customer record);

    @Update({
        "update customer_info",
        "set customer_name = #{customerName,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=BIT},",
          "date_of_birth = #{dateOfBirth,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where customer_id = #{customerId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Customer record);
}