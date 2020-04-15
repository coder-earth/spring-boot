package com.coderearth.springbootcrud.controller;

import java.util.List;

import javax.validation.Valid;

import com.coderearth.springbootcrud.dao.IEmployeeDAO;
import com.coderearth.springbootcrud.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController
{
    @Autowired
    IEmployeeDAO employeeDAO;

    @GetMapping(value = "/list")
    public List<Employee> getList() {

         return employeeDAO.getList();
    }

    @GetMapping(value = "/get/{id}")
    public Employee getById(@PathVariable(value = "id") int empId) {

         return employeeDAO.getById(empId);
    }
    
    @PostMapping(value = "/save")
    public String save(@Valid @RequestBody Employee employee) {

         return employeeDAO.save(employee);
    }

    @PutMapping(value = "/update")
    public String update(@Valid @RequestBody Employee employee) {

         return employeeDAO.update(employee);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") int empId) {

         return employeeDAO.delete(empId);
    }
}