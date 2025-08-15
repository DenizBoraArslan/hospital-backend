package com.db.service.interfaces;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.enums.Role;
import com.db.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

    Optional<Employee> findById(long id);

    Page<Employee> findByEmployeeFirstName(String employeeFirstName, Pageable pageable);

    Page<Employee> findByEmployeeLastName(String employeeLastName, Pageable pageable);

    Optional<Employee> findByEmployeeEmail(String employeeEmail);

    Page<Employee> findByDepartment(Department department, Pageable pageable);

    Page<Employee> findByGender(Gender gender, Pageable pageable);

    Page<Employee> findEmployeeByRole(Role role, Pageable pageable);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    Employee updateEmployee(Employee employee);


}
