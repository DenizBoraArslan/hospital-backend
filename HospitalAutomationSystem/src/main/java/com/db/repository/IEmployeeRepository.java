package com.db.repository;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.enums.Role;
import com.db.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(long id);

    Page<Employee> findByEmployeeFirstName(String employeeFirstName, Pageable pageable);

    Page<Employee> findByEmployeeLastName(String employeeLastName, Pageable pageable);

    Optional<Employee> findByEmployeeEmail(String employeeEmail);

    Page<Employee> findByDepartment(Department department, Pageable pageable);

    Page<Employee> findByGender(Gender gender, Pageable pageable);

    Page<Employee> findEmployeeByRole(Role role, Pageable pageable);


}
