package com.muril.springboot.cruddemo.dao;

import com.muril.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

//Repository que vai tomar conta da implementação dos métodos JPA com entityManager (banco de dados)
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

    @Override
    public Employee findById(Integer employeeId) {
        Employee retrievedEmployee = entityManager.find(Employee.class, employeeId);
        return retrievedEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee); // se id == 0, ele cria um novo employee no banco, se não ele vai atualizar o objeto da id passada
        return dbEmployee; // retorna o novo employee ou o employee atualizado
    }

    @Override
    public void deleteById(Integer employeeId) {
        Employee retrievedEmployee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(retrievedEmployee);
    }
}
