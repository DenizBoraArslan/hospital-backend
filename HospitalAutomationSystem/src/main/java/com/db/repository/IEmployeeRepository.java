package com.db.repository;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.enums.Role;
import com.db.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(long id);

    List<Employee> findByEmployeeFirstName(String employeeFirstName);

    List<Employee> findByEmployeeLastName(String employeeLastName);

    List<Employee> findByEmployeeEmail(String employeeEmail);

    List<Employee> findByDepartment(Department department);

    List<Employee> findByGender(Gender gender);

    List<Employee> findEmployeeByRole(Role role);

}
