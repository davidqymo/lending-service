package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.holidayItem;
import com.xxxx.corebanking.entity.holidayItemKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface holidayItemMapper {
    @Delete({
        "delete from holiday_table",
        "where country_code = #{countryCode,jdbcType=CHAR}",
          "and holiday_area = #{holidayArea,jdbcType=CHAR}",
          "and year_month = #{yearMonth,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(holidayItemKey key);

    @Insert({
        "insert into holiday_table (country_code, holiday_area, ",
        "year_month, holiday_detail, ",
        "create_time, update_time)",
        "values (#{countryCode,jdbcType=CHAR}, #{holidayArea,jdbcType=CHAR}, ",
        "#{yearMonth,jdbcType=INTEGER}, #{holidayDetail,jdbcType=CHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(holidayItem record);

    @InsertProvider(type=holidayItemSqlProvider.class, method="insertSelective")
    int insertSelective(holidayItem record);

    @Select({
        "select",
        "country_code, holiday_area, year_month, holiday_detail, create_time, update_time",
        "from holiday_table",
        "where country_code = #{countryCode,jdbcType=CHAR}",
          "and holiday_area = #{holidayArea,jdbcType=CHAR}",
          "and year_month = #{yearMonth,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="country_code", property="countryCode", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="holiday_area", property="holidayArea", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="year_month", property="yearMonth", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="holiday_detail", property="holidayDetail", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    holidayItem selectByPrimaryKey(holidayItemKey key);

    @UpdateProvider(type=holidayItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(holidayItem record);

    @Update({
        "update holiday_table",
        "set holiday_detail = #{holidayDetail,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where country_code = #{countryCode,jdbcType=CHAR}",
          "and holiday_area = #{holidayArea,jdbcType=CHAR}",
          "and year_month = #{yearMonth,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(holidayItem record);
}