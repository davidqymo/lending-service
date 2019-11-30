package com.xxxx.corebanking.lending.dao;

import com.xxxx.corebanking.lending.entity.LoanAccount_info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoanAccountDAO {

    String SELECT_STMT = "SELECT loan_id, product_id, currency, open_date, customer_id, limit_sequent, limit_type, " +
            "balance, due_date, status, loan_term, loan_term_unit, create_time, update_time FROM loan_account_info" +
            "WHERE loan_id = #{loan_id}";

    String INSERT_STMT = "INSERT INTO loan_account_info (product_id, currency, open_date, customer_id, limit_sequent, limit_type, " +
            "balance, due_date, status, loan_term, loan_term_unit, create_time, update_time) VALUES (#{product_id}, #{currency}, #{open_date}, #{customer_id}, " +
            "#{limit_sequent}, #{limit_type}, #{balance}, #{due_date}, #{status}, #{loan_term}, #{loan_term_unit}, #{create_time}, #{update_time})";

    String DELETE_STMT = "DELETE FROM loan_account_info WHERE loan_id = #{loan_id}";

    String UPDATE_BALANCE_STMT = "UPDATE loan_account_info set balance = #{balance}, set update_time = #{update_time} WHERE loan_id =#{loan_id}";

    @Insert( INSERT_STMT )
    int createLoanAccount(LoanAccount_info account);

    @Select( SELECT_STMT )
    LoanAccount_info getAccountById(int id);

    @Update( UPDATE_BALANCE_STMT )
    int updateLoanAccountBalance(LoanAccount_info account);

    @Delete( DELETE_STMT )
    int deleteAccount(int id);

}
