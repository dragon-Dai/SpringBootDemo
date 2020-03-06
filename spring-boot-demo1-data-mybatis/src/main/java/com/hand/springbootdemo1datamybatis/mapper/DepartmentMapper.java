package com.hand.springbootdemo1datamybatis.mapper;

import com.hand.springbootdemo1datamybatis.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这个一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDepartmentById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")    //获取自动增长的主键
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDepartment(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDepartment(Department department);
}
