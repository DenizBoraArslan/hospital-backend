package com.db.repository;

import com.db.enums.Gender;
import com.db.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findById(long id);

    List<Patient> findByPatientName(String patientName);

    List<Patient> findByPatientLastname(String patientLastname);

    Optional<Patient> findByPatientNationalIdNumber(String patientNationalIdNumber);

    Optional<Patient> findByPatientEmail(String patientEmail);

    Optional<Patient> findPatientByPatientAddress(String patientAddress);

    List<Patient> findPatientByDateOfBirth(LocalDate dateOfBirth);

    List<Patient> findPatientByGender(Gender gender);

}
