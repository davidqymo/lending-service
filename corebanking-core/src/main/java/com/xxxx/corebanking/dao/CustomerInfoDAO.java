package com.xxxx.corebanking.dao;

import com.xxxx.corebanking.entity.Customer_info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface CustomerInfoDAO {

    @Select( CoreBankingSQLStatementConstant.CUSTOMER_SELECT )
    Customer_info getCustomerById(int id);

    @Select( CoreBankingSQLStatementConstant.CUSTOMER_SELECT_ALL )
    List<Customer_info> getAll();

    @Insert( CoreBankingSQLStatementConstant.CUSTOMER_INSERT )
    int insertCustomer(Customer_info customer);

    @Update( CoreBankingSQLStatementConstant.CUSTOMER_UPDATE )
    int updateCustomer(Customer_info customer);

    @Delete( CoreBankingSQLStatementConstant.CUSTOMER_DELETE )
    int deleteCustomer(int id);

    @Select( CoreBankingSQLStatementConstant.CUSTOMER_SELECT_ALL_PAGE )
    List<Customer_info> getAllCustomerMap(int currentPage, int pageSize);

}
