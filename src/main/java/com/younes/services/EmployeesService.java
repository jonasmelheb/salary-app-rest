package com.younes.services;

import com.younes.models.Employee;

import java.util.List;

public interface EmployeesService {
    void addEmployee(Employee employee);

    List<Employee> getListEmployees();

    Employee findEmployeeById(Long searchedId);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}

