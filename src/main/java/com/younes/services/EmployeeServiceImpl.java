package com.younes.services;

import com.younes.models.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeesService{

    private Logger logger = (Logger) LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private List<Employee> employees = Stream.of(
            new Employee("Younes","MELHEB", new BigDecimal(444444), "France"),
            new Employee("Nihad", "Melheb", new BigDecimal(555555), "France"),
            new Employee("Nemra", "MELHEB", new BigDecimal(333333),"France"))
            .collect(Collectors.toList());
    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> getListEmployees() {
        return employees;
    }

    @Override
    public Employee findEmployeeById(Long searchedId) {
        return employees.stream()
                .filter(x -> searchedId.equals((x.getId())))
                .findAny()
                .orElse(null);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee employee1 = findEmployeeById(employee.getId());
        if (employee1 != null) {
            employee1.setFirstname(employee.getFirstname());
            employee1.setLastname(employee.getLastname());
            employee1.setAddress(employee.getAddress());
            employee1.setSalary(employee.getSalary());
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = findEmployeeById(id);
        employees.remove(employee);
    }
}
