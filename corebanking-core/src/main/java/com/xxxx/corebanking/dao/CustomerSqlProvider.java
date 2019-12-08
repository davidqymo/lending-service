package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.Customer;
import org.apache.ibatis.jdbc.SQL;

public class CustomerSqlProvider {
    public String insertSelective(Customer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("customer_info");
        
        if (record.getCustomerName() != null) {
            sql.VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }

        if (record.getGender( ) != 0) {
            sql.VALUES("gender", "#{gender,jdbcType=BIT}");
        }
        
        if (record.getDateOfBirth() != null) {
            sql.VALUES("date_of_birth", "#{dateOfBirth,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Customer record) {
        SQL sql = new SQL();
        sql.UPDATE("customer_info");
        
        if (record.getCustomerName() != null) {
            sql.SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }

        if (record.getGender( ) != 0) {
            sql.SET("gender = #{gender,jdbcType=BIT}");
        }
        
        if (record.getDateOfBirth() != null) {
            sql.SET("date_of_birth = #{dateOfBirth,jdbcType=DATE}");
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
