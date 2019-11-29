MyBatis 笔记(5)


# Paging for SQL statement in MyBatis



### 1st Solution:

Mapper file:

```
    <select id="selectAll" resultType="Customer_info" parameterType="CustomerPageParameters">
        select customer_id,customer_name,gender,date_of_birth date_birth,create_time,update_time
        from customer_info limit #{startIndex}, #{pageNumber}
    </select>
```

then you need to create a entity class for parameters


```
public class CustomerPageParameters {
    private Integer startIndex;
    private Integer pageNumber;

    public CustomerPageParameters(Integer startIndex, Integer pageNumber) {
        this.startIndex = startIndex;
        this.pageNumber = pageNumber;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
```


---


### 2nd solution

Mapper file by using Map

```
    <select id="selectAll" resultType="Customer_info" parameterType="Map">
        select customer_id,customer_name,gender,date_of_birth date_birth,create_time,update_time
        from customer_info limit #{startIndex}, #{pageNumber}
    </select>
```

DAO class


```
    public List<Customer_info> getAllCustomerMap(int currentPage,int pageSize) {

        Map<String,Integer> paramters = new HashMap<String, Integer> ();
        paramters.put( "startIndex", (currentPage -1)*pageSize );
        paramters.put("pageNumber", pageSize);

        List<Customer_info> result = session.selectList( MAPPER_PACKAGE + "selectAll", paramters);
        return result;
    }
```

### 3rd solution:

make use of RowBounds

Mapper file

```
   <select id="getAll" resultType="Customer_info" >
        select customer_id,customer_name,gender,date_of_birth date_birth,create_time,update_time
        from customer_info
    </select>
```

DAO Class


```
    public List<Customer_info> getAll(int currentPage,int pageSize) {
        RowBounds rowBounds = new RowBounds( (currentPage -1 )*pageSize, pageSize );
        List<Customer_info> result = session.selectList( MAPPER_PACKAGE + "getAll", rowBounds);
        return result;
    }
```


