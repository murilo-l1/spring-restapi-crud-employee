package com.muril.springboot.cruddemo.dao;

import com.muril.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

//Repository que vai tomar conta da implementação dos métodos JPA com entityManager

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = employeeQuery.getResultList();
        return employees;
    }
}
