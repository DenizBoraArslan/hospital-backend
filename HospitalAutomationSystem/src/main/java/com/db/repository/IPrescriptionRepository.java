package com.db.repository;

import com.db.models.Doctor;
import com.db.models.Patient;
import com.db.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription, Long> {

    Optional<Prescription> findPrescriptionByPatient(Patient patient);

    List<Prescription> findPrescriptionByDoctor(Doctor doctor);

    List<Prescription> findPrescriptionByPrescriptionDate(LocalDate prescriptionDate);


}
