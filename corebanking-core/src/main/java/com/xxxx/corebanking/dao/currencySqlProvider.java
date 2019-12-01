package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.currency;
import org.apache.ibatis.jdbc.SQL;

public class currencySqlProvider {
    public String insertSelective(currency record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("currency_table");
        
        if (record.getCurrencyCode() != null) {
            sql.VALUES("currency_code", "#{currencyCode,jdbcType=CHAR}");
        }
        
        if (record.getDecimalPoint() != null) {
            sql.VALUES("decimal_point", "#{decimalPoint,jdbcType=BIT}");
        }
        
        if (record.getExchangeRate() != null) {
            sql.VALUES("exchange_rate", "#{exchangeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(currency record) {
        SQL sql = new SQL();
        sql.UPDATE("currency_table");
        
        if (record.getDecimalPoint() != null) {
            sql.SET("decimal_point = #{decimalPoint,jdbcType=BIT}");
        }
        
        if (record.getExchangeRate() != null) {
            sql.SET("exchange_rate = #{exchangeRate,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("currency_code = #{currencyCode,jdbcType=CHAR}");
        
        return sql.toString();
    }
}