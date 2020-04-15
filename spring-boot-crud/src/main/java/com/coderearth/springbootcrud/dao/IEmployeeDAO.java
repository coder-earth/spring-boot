package com.coderearth.springbootcrud.dao;

import java.util.List;

import com.coderearth.springbootcrud.model.Employee;

public interface IEmployeeDAO {
    public List<Employee> getList();
    public Employee getById(Integer empId);
    public String save(Employee employee);
    public String update(Employee employee);
    public String delete(Integer empId);
}