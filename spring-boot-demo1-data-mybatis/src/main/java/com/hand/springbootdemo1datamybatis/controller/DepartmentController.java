package com.hand.springbootdemo1datamybatis.controller;

import com.hand.springbootdemo1datamybatis.bean.Department;
import com.hand.springbootdemo1datamybatis.bean.Employee;
import com.hand.springbootdemo1datamybatis.mapper.DepartmentMapper;
import com.hand.springbootdemo1datamybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/queryDept/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        return departmentMapper.getDepartmentById(id);
    }

    @RequestMapping("/insertDept")
    public Department insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }

    @RequestMapping("/queryEmp/{id}")
    public Employee queryEmployee(@PathVariable Integer id) {
        return employeeMapper.getEmp(id);
    }

    @RequestMapping("/insertEmp")
    public Employee insertEmployee(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }
}
