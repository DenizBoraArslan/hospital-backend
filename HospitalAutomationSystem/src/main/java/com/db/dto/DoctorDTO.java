package com.db.dto;

import com.db.enums.Department;
import com.db.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private Long id;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorEmail;
    private Department department;
    private Gender gender;


}
