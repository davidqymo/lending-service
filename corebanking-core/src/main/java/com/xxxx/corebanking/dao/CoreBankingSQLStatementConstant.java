package com.xxxx.corebanking.dao;

public final class CoreBankingSQLStatementConstant {

    //Customer SQL
    public static final String CUSTOMER_SELECT = "SELECT customer_id, customer_name, gender, date_of_birth, create_time, update_time FROM " +
            "customer_info WHERE customer_id = #{customer_id}";

    public static final String CUSTOMER_INSERT = "INSERT INTO customer_info (customer_name, gender, date_of_birth,create_time, update_time) " +
            "VALUES (#{customer_name}, #{gender}, #{date_of_birth},  #{create_time}, #{update_time})";

    public static final String CUSTOMER_UPDATE = "UPDATE customer_info SET customer_name = #{customer_name}, gender = #{gender}, " +
            "date_of_birth = #{date_of_birth}, update_time = #{update_time} WHERE customer_id = #{customer_id}";

    public static final String CUSTOMER_DELETE = "DELETE FROM customer_info WHERE customer_id = #{customer_id}";

    public static final String CUSTOMER_SELECT_ALL_PAGE = "SELECT customer_id, customer_name, gender, date_of_birth, create_time, update_time FROM customer_info " +
            "LIMIT #{currentPage}, #{pageSize}";

    public static final String CUSTOMER_SELECT_ALL ="SELECT customer_id, customer_name, gender, date_of_birth, create_time, update_time FROM customer_info";

    //CustomerLimit SQL

    public static final String CUSTOMER_LIMIT_SELECT = "SELECT limit_id, customer_id, limit_type, limit_category, original_limit, current_limit, control_limit_id, " +
            "create_time, update_time FROM customer_limit WHERE limit_id = #{limit_id}";

    public static final String CUSTOMER_LIMIT_INSERT = "INSERT INTO customer_limit (customer_id, limit_type, limit_category, original_limit, current_limit, " +
            "control_limit_id, create_time, update_time ) VALUES (#{customer_id}, #{limit_type}, #{limit_category}, " +
            "#{original_limit}, #{current_limit}, #{control_limit_id}, #{create_time}, #{update_time})";

    public static final String CUSTOMER_LIMIT_UPDATE_CURRENT_LIMIT = "UPDATE customer_limit SET current_limit = #{current_limit} WHERE limit_id = #{limit_id}";

    public static final String CUSTOMER_LIMIT_DELETE = "DELETE FROM customer_limit WHERE limit_id = #{limit_id}";

    private CoreBankingSQLStatementConstant() {
    }
}
