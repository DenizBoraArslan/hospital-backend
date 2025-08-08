package com.db.service;

import com.db.models.Doctor;
import com.db.models.Patient;
import com.db.models.Prescription;
import com.db.models.PrescriptionItem;
import com.db.repository.IPrescriptionItemRepository;
import com.db.repository.IPrescriptionRepository;
import com.db.service.interfaces.IPrescriptionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PrescriptionService implements IPrescriptionService {

   private IPrescriptionRepository prescriptionRepository ;

    @Override
    public Optional<Prescription> findPrescriptionByPatient(Patient patient) {
        return prescriptionRepository.findPrescriptionByPatient(patient);
    }

    @Override
    public List<Prescription> findPrescriptionByDoctor(Doctor doctor) {
        return prescriptionRepository.findPrescriptionByDoctor(doctor);
    }

    @Override
    public List<Prescription> findPrescriptionByPrescriptionDate(LocalDate prescriptionDate) {
        return prescriptionRepository.findPrescriptionByPrescriptionDate(prescriptionDate);
    }
}
