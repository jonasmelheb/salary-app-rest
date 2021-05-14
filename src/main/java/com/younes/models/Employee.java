package com.younes.models;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private Long id;
    private static final AtomicInteger count = new AtomicInteger(-1);

    private String firstname;
    private String lastname;
    private BigDecimal salary;
    private String address;

    public Employee(Long id, String firstname, String lastname, BigDecimal salary, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.address = address;
    }

    public Employee(String firstname, String lastname, BigDecimal salary, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                Objects.equals(getFirstname(), employee.getFirstname()) &&
                Objects.equals(getLastname(), employee.getLastname()) &&
                Objects.equals(getSalary(), employee.getSalary()) &&
                Objects.equals(getAddress(), employee.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, salary, address);
    }
}
