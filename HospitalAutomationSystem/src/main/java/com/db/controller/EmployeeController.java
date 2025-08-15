package com.db.controller;


import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.enums.Role;
import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.Employee;
import com.db.service.interfaces.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;


    public ResponseEntity<Page<Employee>> getALlEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> pageResult = employeeService.findAll(pageable);
        return ResponseEntity.ok(pageResult);
    }


    @GetMapping("/getById/{employeeId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable long employeeId) {

        return ResponseEntity.ok(employeeService.findById(employeeId));
    }

    @GetMapping("/getByFirstName/{employeeFirstName}")
    public ResponseEntity<Page<Employee>> findByEmployeeFirstName(@PathVariable String employeeFirstName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> pageResult = employeeService.findByEmployeeFirstName(employeeFirstName, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByLastName/{employeeLastName}")
    public ResponseEntity<Page<Employee>> findByEmployeeLastName(@PathVariable String employeeLastName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> pageResult = employeeService.findByEmployeeLastName(employeeLastName, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByEmail/{employeeEmail}")
    public ResponseEntity<Optional<Employee>> findByEmployeeEmail(@PathVariable String employeeEmail) {

        return ResponseEntity.ok(employeeService.findByEmployeeEmail(employeeEmail));
    }

    @GetMapping("/getByDepartment/{department}")
    public ResponseEntity<Page<Employee>> findByDepartment(@PathVariable Department department, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> pageResult = employeeService.findByDepartment(department, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByGender/{gender}")
    public ResponseEntity<Page<Employee>> findByGender(@PathVariable Gender gender, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> pageResult = employeeService.findByGender(gender, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByRole/{role}")
    public ResponseEntity<Page<Employee>> findEmployeeByRole(@PathVariable Role role, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> pageResult = employeeService.findEmployeeByRole(role, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {

        if (employee.getEmployeeFirstName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_FIRSTNAME_CANNOT_BE_NULL));
        }
        if (employee.getEmployeeLastName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_LASTNAME_CANNOT_BE_NULL));
        }
        if (employee.getEmployeeEmail() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_EMAIL_CANNOT_BE_NULL));
        }
        if (employee.getGender() == null) {
            throw new BaseException(new ErrorMessage(MessageType.GENDER_CANNOT_BE_NULL));
        }
        if (employee.getRole() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_ROLE_CANNOT_BE_NULL));
        }
        if (employee.getDepartment() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DEPARTMENT_CANNOT_BE_NULL));
        }

        return employeeService.saveEmployee(employee);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteEmployee(@RequestBody Employee employee) {

        if (employee.getEmployeeFirstName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_FIRSTNAME_CANNOT_BE_NULL));
        }
        if (employee.getEmployeeLastName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_LASTNAME_CANNOT_BE_NULL));
        }
        if (employee.getEmployeeEmail() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_EMAIL_CANNOT_BE_NULL));
        }
        if (employee.getGender() == null) {
            throw new BaseException(new ErrorMessage(MessageType.GENDER_CANNOT_BE_NULL));
        }
        if (employee.getRole() == null) {
            throw new BaseException(new ErrorMessage(MessageType.EMPLOYEE_ROLE_CANNOT_BE_NULL));
        }
        if (employee.getDepartment() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DEPARTMENT_CANNOT_BE_NULL));
        }

        employeeService.deleteEmployee(employee);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);
    }


}
