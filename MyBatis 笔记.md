# MyBatis学习笔记

# General introdution for MyBatis

MyBatis is Java persistant framework to facilitate the operation with database.


```
What's persistant?
- Data frome flash memory status to persistant median 
- To project, persistant layer means DAO layer)
```


## Tranditional operation with database

1. Load DB driver
2. Connection Pooling
3. Build connection
4. Build Entity Class
5. Build SQL statement
6. Statement/prepare statement execution.
7. Handler the result formating and convert to business object
8. Close the resource (statement, resultset, connection)

## By using MyBatis, you only need to 

1. Build Entity Class
2. Configuration MyBatis (one off)
3. Update the Mapper configuration with SQL statement
4. simple add method in DAO

### Benefit by using MyBatis
1. Reduce the repreated code, improve coding efficency.
1. Manage DB connection (driver,connection pool, connection) by framework.
2. Data manipulate encapsulation for Business Object (your input and output is Business Object)
3. Focus on the business logic

Note:
MyBatis is half-automatiion ORM framework (still need to handle SQL statement)


## Exercise

what's current procedure if introduce new file (HLS DB access) 

what's the improvement by using MyBatis?

---


## Step to use MyBatis with DataBase Access

##### 1. Introduce Maven dependency

      <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>


##### 2. Setup MyBatis Configuration xml file

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- import the database configuration -->
    <properties resource="jdbc.properties"></properties>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!-- 配置连接信息 -->
                <property name="driver" value="${jdbc.driverClass}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    
    <!-- Configuration the Mapper：sql Statement and resultSet  -->
    <mappers>
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>
```
##### 3. Setup properties file

```
jdbc.driverClass=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/smart_lending
jdbc.username=root
jdbc.password=root
```

##### 4. Create SqlSessionFactory Utility

create a uitlity to faciliate the SqlSession. With MyBatis

SqlSessionFactory --> SqlSession --> CRUD on DB

```
package com.xxxx.corebanking.lending.lendingservice;
import java.io.IOException;
import	java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryUtl {

    public static SqlSessionFactory  getInstance() throws IOException {
        String resource = "MyBatis_Config.xml";
        InputStream inputStream = Resources.getResourceAsStream( resource);
        SqlSessionFactory result = new SqlSessionFactoryBuilder().build( inputStream );
        return result;
    }

    public static SqlSession getSqlSession() throws IOException {
        SqlSessionFactory factory = getInstance();
        SqlSession session = factory.openSession();
        return session;
    }
}

```

##### 5. Setup Entity Class


```
package com.hsbc.corebanking.lending.lendingservice.entity;

import java.sql.Date;

public class Customer_info {
    private Integer customer_id;
    private String customer_name;
    private Integer gender;
    private Date date_of_birth;
    private Date create_time;
    private Date update_time;

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Customer_info{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}

```
 


##### 6. Setup Mapper xml file

 Keys:  
 1. namespace, that will be use in sqlSession in DAO
 2. operation (sql statement, return type mapping, parameter mapping)   
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xxxx.corebanking.lending.lendingservice.entity.CustomerMapper">
    <select id="SelectCustomer" resultType="com.xxxx.corebanking.lending.lendingservice.entity.Customer_info">
        select customer_id,customer_name,gender,date_of_birth,create_time,update_time
        from customer_info where customer_id = #{customer_id}
    </select>

    <insert id="AddCustomer" parameterType="com.xxxx.corebanking.lending.lendingservice.entity.Customer_info"
    useGeneratedKeys="true">
        Insert into customer_info (customer_name,gender,date_of_birth,create_time,update_time)
        values(#{customer_name},#{gender},#{date_of_birth},#{create_time},#{update_time})
    </insert>

    <update id="UpdateCustomer" parameterType="com.xxxx.corebanking.lending.lendingservice.entity.Customer_info">
        update customer_info set customer_name =#{customer_name},
        gender = #{gender}, date_of_birth =#{date_of_birth}, update_time =#{update_time}
        where customer_id =#{customer_id}
    </update>

    <delete id="DeleteCustomer" parameterType="com.xxxx.corebanking.lending.lendingservice.entity.Customer_info">
        delete from customer_info where customer_id =#{customer_id}
    </delete>
</mapper>
```


7. Integrate these CRUD in DAO


```
package com.xxxx.corebanking.lending.lendingservice.dao;

import com.xxxx.corebanking.lending.lendingservice.SessionFactoryUtl;
import com.xxxx.corebanking.lending.lendingservice.entity.Customer_info;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class TranditionalCustomerDAO {

    public final static String MAPPER_PACKAGE = "com.xxxx.corebanking.lending.lendingservice.entity.CustomerMapper.";

    public Customer_info getCustomerbyId(int id) throws IOException {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        Customer_info info = session.selectOne(MAPPER_PACKAGE + "SelectCustomer",id );
        session.close();
        return info;
    }

    public int insertCustomer(Customer_info customer) {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        int result = session.insert( MAPPER_PACKAGE +"AddCustomer", customer);
        session.commit();
        session.close();
        return result;
    }

    public int updateCustomer(Customer_info customer) {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        int result = session.update( MAPPER_PACKAGE + "UpdateCustomer",customer );
        session.commit();
        session.close();
        return result;
    }

    public int deleteCustomer(int id) {
        SqlSession session = SessionFactoryUtl.getSqlSession();
        int result = session.delete(MAPPER_PACKAGE + "DeleteCustomer",id);
        session.commit();
        session.close();
        return result;
    }
}

```









