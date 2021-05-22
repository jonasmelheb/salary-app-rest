package com.younes.controllers;

import com.younes.models.Employee;
import com.younes.services.EmployeesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addEmployees(@Valid @RequestBody Employee employee) {
        employeesService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getEmployees() {
        List<Employee> employees = employeesService.getListEmployees();
        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeesById(@PathVariable("id") long id){
        Employee employee = employeesService.findEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity updateEmployees(@RequestBody Employee employee){
        if (employeesService.findEmployeeById(employee.getId()) != null) {
            employeesService.updateEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployees(@PathVariable("id") long id){
        Employee employee = employeesService.findEmployeeById(id);
        if (employee != null) {
            employeesService.deleteEmployee(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
