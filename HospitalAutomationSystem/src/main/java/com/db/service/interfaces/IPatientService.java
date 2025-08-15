package com.db.service.interfaces;

import com.db.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IPatientService {

    Page<Patient> getAllPatients(Pageable pageable);

    Optional<Patient> findById(long id);

    Page<Patient> findByPatientFirstName(String patientFirstName, Pageable pageable);

    Page<Patient> findByPatientLastname(String patientLastname, Pageable pageable);

    Optional<Patient> findByPatientNationalIdNumber(String patientNationalIdNumber);

    Optional<Patient> findByPatientEmail(String patientEmail);

    Optional<Patient> findByPatientPhoneNumber(String patientPhoneNumber);

    Patient save(Patient patient);

    void delete(Long patientId);

    Patient update(Long patientId, Patient patient);

}
