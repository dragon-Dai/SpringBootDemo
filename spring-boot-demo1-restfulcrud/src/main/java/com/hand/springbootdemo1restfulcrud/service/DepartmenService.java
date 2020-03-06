package com.hand.springbootdemo1restfulcrud.service;

import com.hand.springbootdemo1restfulcrud.entity.Department;

import java.util.Collection;


public interface DepartmenService {

    Collection<Department> selectAll();
}
