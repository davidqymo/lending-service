package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.currency;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface currencyMapper {
    @Delete({
        "delete from currency_table",
        "where currency_code = #{currencyCode,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String currencyCode);

    @Insert({
        "insert into currency_table (currency_code, decimal_point, ",
        "exchange_rate, create_time, ",
        "update_time)",
        "values (#{currencyCode,jdbcType=CHAR}, #{decimalPoint,jdbcType=BIT}, ",
        "#{exchangeRate,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(currency record);

    @InsertProvider(type=currencySqlProvider.class, method="insertSelective")
    int insertSelective(currency record);

    @Select({
        "select",
        "currency_code, decimal_point, exchange_rate, create_time, update_time",
        "from currency_table",
        "where currency_code = #{currencyCode,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="currency_code", property="currencyCode", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="decimal_point", property="decimalPoint", jdbcType=JdbcType.BIT),
        @Result(column="exchange_rate", property="exchangeRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    currency selectByPrimaryKey(String currencyCode);

    @UpdateProvider(type=currencySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(currency record);

    @Update({
        "update currency_table",
        "set decimal_point = #{decimalPoint,jdbcType=BIT},",
          "exchange_rate = #{exchangeRate,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where currency_code = #{currencyCode,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(currency record);
}