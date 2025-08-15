package com.db.repository;

import com.db.enums.Gender;
import com.db.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {


    Optional<Patient> findById(long id);

    Page<Patient> findByPatientFirstName(String patientFirstName, Pageable pageable);

    Page<Patient> findByPatientLastname(String patientLastname, Pageable pageable);

    Optional<Patient> findByPatientNationalIdNumber(String patientNationalIdNumber);

    Optional<Patient> findByPatientEmail(String patientEmail);


    Optional<Patient> findPatientByPatientPhoneNumber(String patientPhoneNumber);
}
