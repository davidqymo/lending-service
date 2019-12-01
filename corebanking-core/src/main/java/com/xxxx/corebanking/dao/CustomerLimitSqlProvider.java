package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.CustomerLimit;
import org.apache.ibatis.jdbc.SQL;

public class CustomerLimitSqlProvider {
    public String insertSelective(CustomerLimit record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("customer_limit");
        
        if (record.getCustomerId() != null) {
            sql.VALUES("customer_id", "#{customerId,jdbcType=BIGINT}");
        }
        
        if (record.getLimitType() != null) {
            sql.VALUES("limit_type", "#{limitType,jdbcType=CHAR}");
        }
        
        if (record.getLimitCategory() != null) {
            sql.VALUES("limit_category", "#{limitCategory,jdbcType=CHAR}");
        }
        
        if (record.getOriginalLimit() != null) {
            sql.VALUES("original_limit", "#{originalLimit,jdbcType=BIGINT}");
        }
        
        if (record.getCurrentLimit() != null) {
            sql.VALUES("current_limit", "#{currentLimit,jdbcType=BIGINT}");
        }
        
        if (record.getControlLimitId() != null) {
            sql.VALUES("control_limit_id", "#{controlLimitId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CustomerLimit record) {
        SQL sql = new SQL();
        sql.UPDATE("customer_limit");
        
        if (record.getCustomerId() != null) {
            sql.SET("customer_id = #{customerId,jdbcType=BIGINT}");
        }
        
        if (record.getLimitType() != null) {
            sql.SET("limit_type = #{limitType,jdbcType=CHAR}");
        }
        
        if (record.getLimitCategory() != null) {
            sql.SET("limit_category = #{limitCategory,jdbcType=CHAR}");
        }
        
        if (record.getOriginalLimit() != null) {
            sql.SET("original_limit = #{originalLimit,jdbcType=BIGINT}");
        }
        
        if (record.getCurrentLimit() != null) {
            sql.SET("current_limit = #{currentLimit,jdbcType=BIGINT}");
        }
        
        if (record.getControlLimitId() != null) {
            sql.SET("control_limit_id = #{controlLimitId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("limit_id = #{limitId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}