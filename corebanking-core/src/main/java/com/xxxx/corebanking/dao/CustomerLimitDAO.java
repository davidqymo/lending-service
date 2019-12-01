package com.xxxx.corebanking.dao;
import com.xxxx.corebanking.entity.Customer_limit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


public interface CustomerLimitDAO {
    @Select( CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_SELECT )
    Customer_limit getCustomerLimitById(int id);

//    @Insert( CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_INSERT )
    @Insert( "Insert Into customer_limit (customer_id, limit_type, limit_category, original_limit, current_limit, control_limit_id, create_time, update_time) values ( #{customer_id}, #{limit_type}, #{limit_category}, #{original_limit}, #{current_limit}, #{control_limit_id}, #{create_time}, #{update_time})" )
    @SelectKey( statement = "select last_insert_id()", keyProperty = "limit_id", resultType = Long.class, before = false)
    int addCustomerLimit(Customer_limit limit);

    @Update( CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_UPDATE_CURRENT_LIMIT )
    int updateCustomerCurrentLimit(Customer_limit limit);

    @Delete(CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_DELETE)
    int deleteCustomerLimit(int id);
}
