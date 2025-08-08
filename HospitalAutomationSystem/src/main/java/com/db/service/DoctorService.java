package com.db.service;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.models.Doctor;
import com.db.repository.IDoctorRepository;
import com.db.service.interfaces.IDoctorService;

import java.util.List;
import java.util.Optional;

public class DoctorService implements IDoctorService {

    private IDoctorRepository doctorRepository;

    @Override
    public Optional<Doctor> findById(long doctorId) {
        return doctorRepository.findById(doctorId);
    }

    @Override
    public List<Doctor> findByDoctorFirstName(String doctorFirstName) {
        return doctorRepository.findByDoctorFirstName(doctorFirstName);
    }

    @Override
    public List<Doctor> findByDoctorLastName(String doctorLastName) {
        return doctorRepository.findByDoctorLastName(doctorLastName);
    }

    @Override
    public Optional<Doctor> findByDoctorEmail(String email) {
        return doctorRepository.findByDoctorEmail(email);
    }

    @Override
    public List<Doctor> findByGender(Gender gender) {
        return doctorRepository.findByGender(gender);
    }

    @Override
    public List<Doctor> findByDepartment(Department department) {
        return doctorRepository.findByDepartment(department);
    }
}
