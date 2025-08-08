package com.db.service.interfaces;

import com.db.models.Doctor;
import com.db.models.Patient;
import com.db.models.Prescription;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPrescriptionService {

    Optional<Prescription> findPrescriptionByPatient(Patient patient);

    List<Prescription> findPrescriptionByDoctor(Doctor doctor);

    List<Prescription> findPrescriptionByPrescriptionDate(LocalDate prescriptionDate);

}
