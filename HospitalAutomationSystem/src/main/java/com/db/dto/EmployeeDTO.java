package com.db.dto;

import com.db.enums.Department;
import com.db.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private Department department;
    private Gender gender;


}
