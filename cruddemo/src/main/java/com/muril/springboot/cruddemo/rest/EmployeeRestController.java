package com.muril.springboot.cruddemo.rest;

import com.muril.springboot.cruddemo.entity.Employee;
import com.muril.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.muril.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //injetando a interface de Service no controller
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expondo o endpoint de employees para mostrar o JSON de todos do bd
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId){
        Employee retrievedEmployee = employeeService.findById(employeeId);
        if(retrievedEmployee == null){
            throw new EmployeeNotFoundException("Employee with " + employeeId + " id not found.");
        }
        return retrievedEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // se eles passarem uma id no JSON vamos setar ela pra 0 assim .merge() de fato cria um novo employee
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        List<Employee> employees = employeeService.findAll();
        if(theEmployee.getId() >= employees.size()){
            throw new EmployeeNotFoundException("Can't udpate employee with id " + theEmployee.getId());
        }
        Employee updatedEmployee = employeeService.save(theEmployee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable Integer employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new EmployeeNotFoundException("Employee with id " + employeeId + " can't be deleted");
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee with id " + employeeId;
    }

}
