package com.hand.springbootdemo1datamybatis.mapper;

import com.hand.springbootdemo1datamybatis.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface EmployeeMapper {

    //    @Select("select * from employee where id=#{id}")
    public Employee getEmp(@PathVariable Integer id);

    //    @Insert("insert into employee(lastName,email,gender,d_id) values(#lastName,#email,#gender,#dId,)")
    public int insertEmp(Employee employee);
}
