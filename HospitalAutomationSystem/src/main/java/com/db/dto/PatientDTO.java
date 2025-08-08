package com.db.dto;

import com.db.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;
    private String patientFirstName;
    private String patientLastName;
    private String nationalIdNumber;
    private String patientEmail;
    private String patientAddress;
    private String patientPhoneNumber;
    private LocalDate dateOfBirth;
    private Gender gender;

}
