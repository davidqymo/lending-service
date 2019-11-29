# MyBatis 笔记 （2）

分析MyBatis配置文件


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

### <environment>

each environment can have ites specific setting

e.g. master-slaver mode, then you can have two environment's setup

### <transactionManager> 

transaction management

###### JDBC 

simple transaction managed by JDBC.

###### MANAGED 

integrated with container e.g. spring java ee , then container level to manage the trasaction.

   if use MANAGED, then need to set properties <closeConnection> as false
   

```
<transactionManager type ="MANAGED">
       <property name = "closeConnection" value ="false" />
   </transactionManager>
```

### <dataSource> 

data source type 


##### UNPOOLED  

Need to open/close connection each time, for simple application. basically it has 5 properties
 driver
 url
 username
 password
 defaultTransactionIsolationLevel
    


##### POOLED  

implemented cache mechanisum for the JDBC connection to avoid initilization and authentation each time. it has bellow properties


```
poolMaximumActiveConnections 
- any specific time max connections allowed - default 10

poolMaximumIdleConnections  
- any specific time idle connections allowed 

poolMaximumCheckoutTime 
- before pool return, max check out time (20000 ms)

poolTimeToWait - 

poolPingQuery 
- SQL query to perform health check to ensure connection is alive.

poolPingEnable 
- default is false;
```

##### JNDI

This is used for Java EE container/Spring. it has two properties

initial_contex   use for initial context for lookup 


data_source



## Mapper 

define the mapping with SQL statement's file

resource  - location of mapper file.   e.g. /com/xxxx/UserMapper.xml


## Mapping configuration file


#### namespace 

avoid the duplicated id of sql statement id. normally it should be corresponding package + entity class name + mapper.

e.g. com.xxxx.corebanking.lendingservice.entity.Customer_infoMapper

###### <id>

under the namespace, you can define ID for the specific  SQL statement.

###### <resultType>

return type of the resultSet, system will automatically convert the resultset to the specific entities object.

###### <parameterType>

parameter Type of the input parameters

###### <useGeneratedKey>

use the auto increasement primary key or not. true/false


