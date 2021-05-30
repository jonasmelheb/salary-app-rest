package com.younes.services;

import com.younes.models.Employee;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EmployeesServiceImplTest {
    private EmployeeServiceImpl employeeServiceImpl;

 /*   @Before
    public void setUp() {
        employeeServiceImpl = new EmployeeServiceImpl();
    }*/

    @Test
    public void addEmployees() throws Exception {
        List<Employee> employees = employeeServiceImpl.getListEmployees();
        int sizeBefore = employees.size();
        Employee employee = new Employee("test", "test", new BigDecimal(4444), "test");
        employeeServiceImpl.addEmployee(employee);
        int sizeAfter = employees.size();

        assertThat(sizeAfter, is(sizeBefore + 1 ));

        Employee employee1 = employees.get(employees.size() - 1);
        assertEquals("test", employee1.getFirstname());
    }

    @Test
    public void addEmployeeNotEmpty() throws Exception {
        Employee employee = new Employee("test","test", new BigDecimal(4444),"test");
        employeeServiceImpl.addEmployee(employee);

        assertFalse(employee.getFirstname().isEmpty());
        assertFalse(employee.getLastname().isEmpty());
        assertFalse(employee.getAddress().isEmpty());
    }

    @Test
    public void addEmployeeNotNull() throws Exception {
        Employee employee = new Employee("test","test", new BigDecimal(4444),"test");
        List<Employee> employees = employeeServiceImpl.getListEmployees();
        employees.add(employee);
        int lastItem = employees.size() - 1;

        assertNotNull(employees.get(lastItem).getFirstname());
        assertNotNull(employees.get(lastItem).getLastname());
        assertNotNull(employees.get(lastItem).getAddress());
        assertFalse(employees.get(lastItem).getAddress().length() > 256);
    }

    @Test
    public void findEmployeeById() throws Exception {
        List<Employee> employees = employeeServiceImpl.getListEmployees();
        Employee employee = new Employee((long) 55,"FindYounes", "test", new BigDecimal(4444), "test");
        employees.add(employee);
        Employee employee1 = employeeServiceImpl.findEmployeeById((long) 55);

        assertThat(employee1.getId(), is(employee.getId()));
        assertThat(employee1.getFirstname(), is(employee.getFirstname()));
        assertThat(employee1.getLastname(), is(employee.getLastname()));
        assertThat(employee1.getSalary(), is(employee.getSalary()));
        assertThat(employee1.getAddress(), is(employee.getAddress()));
    }

    @Test
    public void deleteEmployee() throws Exception {
        List<Employee> employees = employeeServiceImpl.getListEmployees();
        int sizeBefore = employees.size();
        employeeServiceImpl.deleteEmployee((long) 2);
        int sizeAfter = employees.size();

        assertThat(sizeAfter, is(sizeBefore - 1));
    }

    @Test
    public void updateEmployee() throws Exception {
        List<Employee> employees = employeeServiceImpl.getListEmployees();
        Employee employee = new Employee((long)60, "You", "Nes", new BigDecimal(12345), "adress");
        employees.add(employee);
        Employee employee1 = new Employee((long)60, "UpdatedYou", "UpdatedNes", new BigDecimal(54321), "UpdatedAdress");
        employeeServiceImpl.updateEmployee(employee1);
        int lastItem = employees.size() - 1;

        assertThat(employees.get(lastItem).getFirstname(), is("UpdatedYou"));
        assertThat(employees.get(lastItem).getLastname(), is("UpdatedNes"));
        assertThat(employees.get(lastItem).getAddress(), is("UpdatedAdress"));
    }

}
