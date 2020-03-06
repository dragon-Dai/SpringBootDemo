package com.hand.springbootdemo1restfulcrud.entity;

import java.util.Collection;

public class Department {

    private Integer id;
    private String departmentName;
    private Collection<Employee> employees;

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public Department() {
    }

    public Department(int i, String string) {
        this.id = i;
        this.departmentName = string;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
