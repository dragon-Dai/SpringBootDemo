package com.hand.springbootdemo1restfulcrud.service.impl;

import com.hand.springbootdemo1restfulcrud.entity.Employee;
import com.hand.springbootdemo1restfulcrud.mapper.EmployeeMapper;
import com.hand.springbootdemo1restfulcrud.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> login(Employee employee) {
        return employeeMapper.login(employee);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public Employee selectOneById(Integer id) {
        return employeeMapper.selectOneById(id);
    }

    @Override
    public Integer create(Employee employee) {
        return employeeMapper.addOne(employee);
    }

    @Override
    public Integer update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public Integer deleteById(Integer id) {
        return employeeMapper.deleteById(id);
    }
}
