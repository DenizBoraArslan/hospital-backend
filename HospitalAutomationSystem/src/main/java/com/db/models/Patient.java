package com.db.models;

import com.db.enums.Gender;
import com.db.enums.InsuranceType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseEntity {

    private String patientFirstName;

    private String patientLastname;

    private String patientNationalIdNumber;

    private String patientEmail;

    private String patientAddress;

    private String patientPhoneNumber;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @Enumerated(EnumType.STRING)
    private Gender gender;



}
