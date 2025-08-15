package com.db.service;


import com.db.models.Doctor;
import com.db.models.Patient;
import com.db.models.Prescription;
import com.db.repository.IPrescriptionRepository;
import com.db.service.interfaces.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

@Service
public class PrescriptionService implements IPrescriptionService {

    @Autowired
    private IPrescriptionRepository prescriptionRepository;


    @Override
    public Page<Prescription> findPrescriptionByPatient(Patient patient, Pageable pageable) {
        return prescriptionRepository.findPrescriptionByPatient(patient, pageable);
    }

    @Override
    public Page<Prescription> findPrescriptionByDoctor(Doctor doctor, Pageable pageable) {

        return prescriptionRepository.findPrescriptionByDoctor(doctor, pageable);
    }

    @Override
    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public void deletePrescription(Long id) {

        prescriptionRepository.deleteById(id);

    }

    @Override
    public Prescription updatePrescription(Long id, Prescription prescription) {
        return prescriptionRepository.findById(id).map(existingPrescription ->{

            existingPrescription.setDoctor(prescription.getDoctor());
            existingPrescription.setPatient(prescription.getPatient());
            existingPrescription.setPrescriptionDate(prescription.getPrescriptionDate());

            return prescriptionRepository.save(existingPrescription);
        }).orElseThrow(()->new RuntimeException("Prescription Not Found With Id: " + id));
    }
}
