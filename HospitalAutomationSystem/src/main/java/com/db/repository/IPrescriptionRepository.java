package com.db.repository;


import com.db.models.Doctor;
import com.db.models.Patient;
import com.db.models.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription, Long> {

    Page<Prescription> findPrescriptionByPatient(Patient patient, Pageable pageable);

    Page<Prescription> findPrescriptionByDoctor(Doctor doctor, Pageable pageable);


}
