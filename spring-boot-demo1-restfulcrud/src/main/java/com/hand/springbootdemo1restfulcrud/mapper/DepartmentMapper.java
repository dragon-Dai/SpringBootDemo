package com.hand.springbootdemo1restfulcrud.mapper;

import com.hand.springbootdemo1restfulcrud.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface DepartmentMapper {

    Collection<Department> selectAll();
}
