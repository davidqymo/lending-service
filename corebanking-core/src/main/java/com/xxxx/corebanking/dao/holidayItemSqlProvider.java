package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.holidayItem;
import org.apache.ibatis.jdbc.SQL;

public class holidayItemSqlProvider {
    public String insertSelective(holidayItem record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("holiday_table");
        
        if (record.getCountryCode() != null) {
            sql.VALUES("country_code", "#{countryCode,jdbcType=CHAR}");
        }
        
        if (record.getHolidayArea() != null) {
            sql.VALUES("holiday_area", "#{holidayArea,jdbcType=CHAR}");
        }
        
        if (record.getYearMonth() != null) {
            sql.VALUES("year_month", "#{yearMonth,jdbcType=INTEGER}");
        }
        
        if (record.getHolidayDetail() != null) {
            sql.VALUES("holiday_detail", "#{holidayDetail,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(holidayItem record) {
        SQL sql = new SQL();
        sql.UPDATE("holiday_table");
        
        if (record.getHolidayDetail() != null) {
            sql.SET("holiday_detail = #{holidayDetail,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("country_code = #{countryCode,jdbcType=CHAR}");
        sql.WHERE("holiday_area = #{holidayArea,jdbcType=CHAR}");
        sql.WHERE("year_month = #{yearMonth,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}