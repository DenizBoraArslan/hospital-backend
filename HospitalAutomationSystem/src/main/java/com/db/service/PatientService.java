package com.db.service;

import com.db.models.Patient;
import com.db.repository.IPatientRepository;
import com.db.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public Page<Patient> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Optional<Patient> findById(long id) {

        return patientRepository.findById(id);
    }

    @Override
    public Page<Patient> findByPatientFirstName(String patientFirstName, Pageable pageable) {
        return patientRepository.findByPatientFirstName(patientFirstName, pageable);
    }

    @Override
    public Page<Patient> findByPatientLastname(String patientLastname, Pageable pageable) {
        return patientRepository.findByPatientLastname(patientLastname, pageable);
    }

    @Override
    public Optional<Patient> findByPatientNationalIdNumber(String patientNationalIdNumber) {
        return patientRepository.findByPatientNationalIdNumber(patientNationalIdNumber);
    }

    @Override
    public Optional<Patient> findByPatientEmail(String patientEmail) {
        return patientRepository.findByPatientEmail(patientEmail);
    }

    @Override
    public Optional<Patient> findByPatientPhoneNumber(String patientPhoneNumber) {
        return patientRepository.findPatientByPatientPhoneNumber(patientPhoneNumber);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Long patientId) {
        if(!patientRepository.existsById(patientId)) {
            throw new RuntimeException("Patient not found with id: " + patientId);
        }


        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient update(Long patientId, Patient patient) {
        return patientRepository.findById(patientId).map(existingPatient ->{

            existingPatient.setPatientFirstName(patient.getPatientFirstName());
            existingPatient.setPatientLastname(patient.getPatientLastname());
            existingPatient.setPatientNationalIdNumber(patient.getPatientNationalIdNumber());
            existingPatient.setPatientEmail(patient.getPatientEmail());
            existingPatient.setPatientPhoneNumber(patient.getPatientPhoneNumber());
            existingPatient.setPatientAddress(patient.getPatientAddress());
            existingPatient.setDateOfBirth(patient.getDateOfBirth());
            return patientRepository.save(patient);

        }).orElseThrow(()-> new RuntimeException("Patient not found with id :" +patientId));


    }


}
