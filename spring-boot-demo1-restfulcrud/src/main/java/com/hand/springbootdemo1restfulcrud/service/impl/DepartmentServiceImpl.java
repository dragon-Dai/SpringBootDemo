package com.hand.springbootdemo1restfulcrud.service.impl;

import com.hand.springbootdemo1restfulcrud.entity.Department;
import com.hand.springbootdemo1restfulcrud.mapper.DepartmentMapper;
import com.hand.springbootdemo1restfulcrud.service.DepartmenService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmenService {

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Collection<Department> selectAll() {
        return departmentMapper.selectAll();
    }
}
