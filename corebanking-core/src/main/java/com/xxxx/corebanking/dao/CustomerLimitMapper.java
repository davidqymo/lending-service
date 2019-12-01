package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.CustomerLimit;
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

public interface CustomerLimitMapper {
    @Delete({
        "delete from customer_limit",
        "where limit_id = #{limitId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long limitId);

    @Insert({
        "insert into customer_limit (customer_id, limit_type, ",
        "limit_category, original_limit, ",
        "current_limit, control_limit_id, ",
        "create_time, update_time)",
        "values (#{customerId,jdbcType=BIGINT}, #{limitType,jdbcType=CHAR}, ",
        "#{limitCategory,jdbcType=CHAR}, #{originalLimit,jdbcType=BIGINT}, ",
        "#{currentLimit,jdbcType=BIGINT}, #{controlLimitId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="limitId", before=false, resultType=Long.class)
    int insert(CustomerLimit record);

    @InsertProvider(type=CustomerLimitSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="limitId", before=false, resultType=Long.class)
    int insertSelective(CustomerLimit record);

    @Select({
        "select",
        "limit_id, customer_id, limit_type, limit_category, original_limit, current_limit, ",
        "control_limit_id, create_time, update_time",
        "from customer_limit",
        "where limit_id = #{limitId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="limit_id", property="limitId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.BIGINT),
        @Result(column="limit_type", property="limitType", jdbcType=JdbcType.CHAR),
        @Result(column="limit_category", property="limitCategory", jdbcType=JdbcType.CHAR),
        @Result(column="original_limit", property="originalLimit", jdbcType=JdbcType.BIGINT),
        @Result(column="current_limit", property="currentLimit", jdbcType=JdbcType.BIGINT),
        @Result(column="control_limit_id", property="controlLimitId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CustomerLimit selectByPrimaryKey(Long limitId);

    @UpdateProvider(type=CustomerLimitSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CustomerLimit record);

    @Update({
        "update customer_limit",
        "set customer_id = #{customerId,jdbcType=BIGINT},",
          "limit_type = #{limitType,jdbcType=CHAR},",
          "limit_category = #{limitCategory,jdbcType=CHAR},",
          "original_limit = #{originalLimit,jdbcType=BIGINT},",
          "current_limit = #{currentLimit,jdbcType=BIGINT},",
          "control_limit_id = #{controlLimitId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where limit_id = #{limitId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CustomerLimit record);
}