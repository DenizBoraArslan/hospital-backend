package com.db.service;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.enums.Role;
import com.db.models.Employee;
import com.db.repository.IEmployeeRepository;
import com.db.service.interfaces.IEmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByEmployeeFirstName(String employeeFirstName) {
        return employeeRepository.findByEmployeeFirstName(employeeFirstName);
    }

    @Override
    public List<Employee> findByEmployeeLastName(String employeeLastName) {
        return employeeRepository.findByEmployeeLastName(employeeLastName);
    }

    @Override
    public List<Employee> findByEmployeeEmail(String employeeEmail) {
        return employeeRepository.findByEmployeeEmail(employeeEmail);
    }

    @Override
    public List<Employee> findByDepartment(Department department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public List<Employee> findByGender(Gender gender) {
        return employeeRepository.findByGender(gender);
    }

    @Override
    public List<Employee> findEmployeeByRole(Role role) {
        return employeeRepository.findEmployeeByRole(role);
    }
}
