package com.younes.repositories;

import com.younes.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByFirstname(String firstname);

    Employee findEmployeeById(Long id);
}
