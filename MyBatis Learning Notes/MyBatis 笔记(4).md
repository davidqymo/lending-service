MyBatis 笔记（4）

### How to resolve the properties name (entity class) vs field name (DB table) mismatch


### Example:

in Database Table user,  the field name is "date_of_birth" while in Entity Class,  the property is "date_birth".  what happen if we run the program to get the User ?

The result is that the pwd properties is null, the password value could not be injected into entity class object.


### Solution:


##### 1> make use of alais


```
   <select id="SelectCustomer" resultType="Customer_info">
        select customer_id,customer_name,gender,date_of_birth date_birth,create_time,update_time
        from customer_info where customer_id = #{customer_id}
    </select>
```


##### 2> make use ResultMap


```
    <select id="SelectCustomer" resultMap="CustomerMap">
        select customer_id,customer_name,gender,date_of_birth,create_time,update_time
        from customer_info where customer_id = #{customer_id}
    </select>
    <resultMap id="CustomerMap" type="Customer_info" >
        <id column="customer_id" property="customer_id" />
        <result column="customer_name" property="customer_name" />
        <result column="gender" property="gender" />
        <result column="date_of_birth" property="date_birth" />
        <result column="create_time" property="create_time" />
        <result column="update_time" property="update_time" />
    </resultMap>
```





