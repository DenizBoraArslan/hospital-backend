package com.db.service;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.enums.Role;
import com.db.models.Employee;
import com.db.repository.IEmployeeRepository;
import com.db.service.interfaces.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> findByEmployeeFirstName(String employeeFirstName, Pageable pageable) {
        return employeeRepository.findByEmployeeFirstName(employeeFirstName, pageable);
    }

    @Override
    public Page<Employee> findByEmployeeLastName(String employeeLastName, Pageable pageable) {
        return employeeRepository.findByEmployeeLastName(employeeLastName, pageable);
    }

    @Override
    public Optional<Employee> findByEmployeeEmail(String employeeEmail) {
        return employeeRepository.findByEmployeeEmail(employeeEmail);
    }

    @Override
    public Page<Employee> findByDepartment(Department department, Pageable pageable) {
        return employeeRepository.findByDepartment(department, pageable);
    }

    @Override
    public Page<Employee> findByGender(Gender gender, Pageable pageable) {
        return employeeRepository.findByGender(gender, pageable);
    }

    @Override
    public Page<Employee> findEmployeeByRole(Role role, Pageable pageable) {
        return employeeRepository.findEmployeeByRole(role, pageable);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {

        employeeRepository.delete(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
