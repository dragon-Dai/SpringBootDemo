package com.hand.springbootdemo1restfulcrud.mapper;

import com.hand.springbootdemo1restfulcrud.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> login(Employee employee);

    List<Employee> selectAll();

    Employee selectOneById(@Param(value = "id") Integer id);

    Integer addOne(Employee employee);

    Integer deleteById(Integer id);

    Integer update(Employee employee);

}
