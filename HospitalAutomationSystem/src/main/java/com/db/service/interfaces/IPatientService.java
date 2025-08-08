package com.db.service.interfaces;

import com.db.enums.Gender;
import com.db.models.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPatientService {

    Optional<Patient> findById(long id);
    List<Patient> findByPatientFirstName(String patientFirstName);
    List<Patient> findByPatientLastname(String patientLastname);
    Optional<Patient> findByPatientNationalIdNumber(String patientNationalIdNumber);
    Optional<Patient> findByPatientEmail(String patientEmail);
    Optional<Patient> findPatientByPatientAddress(String patientAddress);
    List<Patient> findPatientByDateOfBirth(LocalDate dateOfBirth);
    List<Patient> findPatientByGender(Gender gender);

}
