# MyBatis 笔记（3）


## Optimzed MyBatis configuration



### properties

we can make use <properties> to externlize the properties configuration.



```
<properties resource="jdbc.properties"></properties>
 ...
    <dataSource type="POOLED">
    <!-- 配置连接信息 -->
        <property name="driver" value="${jdbc.driverClass}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </dataSource>
```


jdbc.properties


```
jdbc.driverClass=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/smart_lending
jdbc.username=root
jdbc.password=root
```

### typeAliases

we can make use of this for Mapper's returnType, parameterType


**++typeAlias++**

we can use the typeAlias for the mapper xml file define.

```
<typeAliases>
    <typeAlias type="com.xxxx.corebanking.lending.lendingservice.entity.Customer_info" alias="Customer" />
/typeAliases>
```


in Mapper xml file


```
<select id="SelectCustomer" resultType="Customer">
    select customer_id,customer_name,gender,date_of_birth,create_time,update_time
    from customer_info where customer_id = #{customer_id}
</select>
```

**++package++**

MyBatis will scan all the class under this package, then in your mapper, you just simple to use the classname, myBatis can locate it

```
<typeAliases>
    <package name="com.xxxx.corebanking.lending.lendingservice.entity" />
</typeAliases>
```

in Mapper file


```
<select id="SelectCustomer" resultType="Customer_info">
        select customer_id,customer_name,gender,date_of_birth,create_time,update_time
        from customer_info where customer_id = #{customer_id}
</select>
```


