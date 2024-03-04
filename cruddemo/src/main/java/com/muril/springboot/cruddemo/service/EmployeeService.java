package com.muril.springboot.cruddemo.service;

import com.muril.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer employeeId);
    Employee save(Employee theEmployee);
    void deleteById(Integer employeeId);
}
