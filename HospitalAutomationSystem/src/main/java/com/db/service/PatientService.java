package com.db.service;

import com.db.enums.Gender;
import com.db.models.Patient;
import com.db.repository.IAppointmentRepository;
import com.db.repository.IPatientRepository;
import com.db.service.interfaces.IPatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    private IPatientRepository patientRepository;

    @Override
    public Optional<Patient> findById(long id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findByPatientFirstName(String patientFirstName) {
        return patientRepository.findByPatientFirstName(patientFirstName);
    }

    @Override
    public List<Patient> findByPatientLastname(String patientLastname) {
        return patientRepository.findByPatientLastname(patientLastname);
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
    public Optional<Patient> findPatientByPatientAddress(String patientAddress) {
        return patientRepository.findPatientByPatientAddress(patientAddress);
    }

    @Override
    public List<Patient> findPatientByDateOfBirth(LocalDate dateOfBirth) {
        return patientRepository.findPatientByDateOfBirth(dateOfBirth);
    }

    @Override
    public List<Patient> findPatientByGender(Gender gender) {
        return patientRepository.findPatientByGender(gender);
    }
}
