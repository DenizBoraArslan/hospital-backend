package com.db.service.interfaces;


import com.db.models.Doctor;
import com.db.models.Patient;
import com.db.models.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPrescriptionService {

    Page<Prescription> findPrescriptionByPatient(Patient patient, Pageable pageable);

    Page<Prescription> findPrescriptionByDoctor(Doctor doctor, Pageable pageable);

    Prescription savePrescription(Prescription prescription);

    void deletePrescription(Long id);

    Prescription updatePrescription(Long id,Prescription prescription);


}
