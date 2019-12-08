package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.CustomerMapping;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CustomerMappingMapper {
    @Delete({
        "delete from customer_mapping",
        "where customer_id = #{customerId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long customerId);

    @Insert({
        "insert into customer_mapping (customer_id, system_code, ",
        "ext_customer_num, create_time, ",
        "update_time)",
        "values (#{customerId,jdbcType=BIGINT}, #{systemCode,jdbcType=VARCHAR}, ",
        "#{extCustomerNum,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(CustomerMapping record) throws Exception;

    @InsertProvider(type=CustomerMappingSqlProvider.class, method="insertSelective")
    int insertSelective(CustomerMapping record);

    @Select({
        "select",
        "customer_id, system_code, ext_customer_num, create_time, update_time",
        "from customer_mapping",
        "where customer_id = #{customerId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="system_code", property="systemCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ext_customer_num", property="extCustomerNum", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CustomerMapping selectByPrimaryKey(Long customerId);

    @UpdateProvider(type=CustomerMappingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CustomerMapping record);

    @Update({
        "update customer_mapping",
        "set system_code = #{systemCode,jdbcType=VARCHAR},",
          "ext_customer_num = #{extCustomerNum,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where customer_id = #{customerId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CustomerMapping record);
}
