package com.muril.springboot.cruddemo.dao;

import com.muril.springboot.cruddemo.entity.Employee;
import java.util.List;

// DAO que vai conter os métodos CRUD do employee

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(Integer employeeId);
    Employee save(Employee theEmployee);
    void deleteById(Integer employeeId);

}
