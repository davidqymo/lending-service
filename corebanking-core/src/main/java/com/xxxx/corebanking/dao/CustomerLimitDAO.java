package com.xxxx.corebanking.dao;
import com.xxxx.corebanking.entity.Customer_limit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface CustomerLimitDAO {
    @Select( CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_SELECT )
    Customer_limit getCustomerLimitById(int id);

    @Insert( CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_INSERT )
    int addCustomerLimit(Customer_limit limit);

    @Update( CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_UPDATE_CURRENT_LIMIT )
    int updateCustomerCurrentLimit(Customer_limit limit);

    @Delete(CoreBankingSQLStatementConstant.CUSTOMER_LIMIT_DELETE)
    int deleteCustomerLimit(int id);
}
