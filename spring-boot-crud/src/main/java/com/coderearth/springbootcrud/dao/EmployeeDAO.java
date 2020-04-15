package com.coderearth.springbootcrud.dao;

import java.util.List;

import com.coderearth.springbootcrud.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO implements IEmployeeDAO
{
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Employee> getList() {

        return jdbcTemplate.query(
            "SELECT "
            +"emp_id,emp_name,designation,address,phone_no "
            +"FROM emp_master ",
            new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee getById(Integer empId) {
        return jdbcTemplate.queryForObject(
            "SELECT "
            +"emp_id,emp_name,designation,address,phone_no "
            +"FROM emp_master "
            +"WHERE emp_id = ?",
            new Object[] {empId},new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public String save(Employee employee) {
       jdbcTemplate.update(
            "INSERT INTO emp_master "
            +"(emp_name,designation,address,phone_no) "
            +"VALUES (?,?,?,?)", 
            new Object[] {employee.getEmpName(),employee.getDesignation(),
                employee.getAddress(),employee.getPhoneNo()});

        return "Saved";
        
    }

    @Override
    public String update(Employee employee) {
        jdbcTemplate.update(
            "UPDATE emp_master "
            +"SET emp_name = ?,designation = ?,address = ?,phone_no = ? "
            +"WHERE emp_id = ?",
            new Object[] {employee.getEmpName(),
                employee.getDesignation(),employee.getAddress(),
                employee.getPhoneNo(),employee.getEmpId()});
        return "Updated";
        
    }

    @Override
    public String delete(Integer empId) {
        jdbcTemplate.update(
            "DELETE FROM emp_master WHERE emp_id = ?",
            new Object[] {empId});   
        return "Deleted";   
    }

}