package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.CustomerMapping;
import org.apache.ibatis.jdbc.SQL;

public class CustomerMappingSqlProvider {
    public String insertSelective(CustomerMapping record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("customer_mapping");
        
        if (record.getCustomerId() != null) {
            sql.VALUES("customer_id", "#{customerId,jdbcType=BIGINT}");
        }
        
        if (record.getSystemCode() != null) {
            sql.VALUES("system_code", "#{systemCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExtCustomerNum() != null) {
            sql.VALUES("ext_customer_num", "#{extCustomerNum,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CustomerMapping record) {
        SQL sql = new SQL();
        sql.UPDATE("customer_mapping");
        
        if (record.getSystemCode() != null) {
            sql.SET("system_code = #{systemCode,jdbcType=VARCHAR}");
        }
        
        if (record.getExtCustomerNum() != null) {
            sql.SET("ext_customer_num = #{extCustomerNum,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("customer_id = #{customerId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}