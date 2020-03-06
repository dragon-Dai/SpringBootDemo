package com.hand.springbootdemo1restfulcrud.service;

import com.hand.springbootdemo1restfulcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 登录
     * @param employee： 登录用户
     * @return
     */
    List<Employee> login(Employee employee);

    /**
     * 查询所有员工信息：包含部门信息
     * @return
     */
    List<Employee> selectAll();

    /**
     * 根据员工id，查询员工信息：包含部门信息
     * @param id：员工id
     * @return
     */
    Employee selectOneById(Integer id);

    /**
     * 创建新的的员工
     * @param employee： 员工信息
     * @return
     */
    Integer create(Employee employee);

    /**
     * 更新员工信息
     * @param employee：员工信息
     * @return
     */
    Integer update(Employee employee);

    /**
     * 根据员工id，删除员工信息
     * @param id：员工id
     * @return
     */
    Integer deleteById(Integer id);
}
