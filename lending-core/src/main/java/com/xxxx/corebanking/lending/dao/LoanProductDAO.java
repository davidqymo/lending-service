package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LoanProductDAO {

    String SELECT_STMT = "SELECT product_id, product_description,create_time,update_time " +
            "FROM loan_product_control WHERE product_id = #{product_id}";

    String INSERT_STMT = "INSERT INTO loan_product_control ( product_id, product_description, create_time, update_time) " +
            " VALUES (#{product_id}, #{product_description}, #{create_time}, #{update_time})";


    @Select(SELECT_STMT)
    LoanProduct getProductById(String productId);

    @Insert(INSERT_STMT)
    int insertProduct(LoanProduct product);
}
