package com.db.service;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.Doctor;

import com.db.repository.IDoctorRepository;
import com.db.service.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Override
    public Page<Doctor> findAllDoctorsByGender(Gender gender, Pageable pageable) {

        if (gender == null) {
            throw new BaseException(new ErrorMessage(MessageType.GENDER_CANNOT_BE_NULL));
        }
        return doctorRepository.findAllDoctorsByGender(gender, pageable);
    }

    @Override
    public Page<Doctor> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    @Override
    public Page<Doctor> getAllDoctorsByDepartment(Department department, Pageable pageable) {

        return doctorRepository.getAllDoctorsByDepartment(department, pageable);
    }

    @Override
    public Optional<Doctor> findById(long doctorId) {
        return doctorRepository.findById(doctorId);
    }

    @Override
    public Page<Doctor> findByDoctorFirstName(String doctorFirstName, Pageable pageable) {
        return doctorRepository.findByDoctorFirstName(doctorFirstName, pageable);
    }

    @Override
    public Page<Doctor> findByDoctorLastName(String doctorLastName, Pageable pageable) {
        return doctorRepository.findByDoctorLastName(doctorLastName, pageable);
    }

    @Override
    public Optional<Doctor> findByDoctorEmail(String email) {
        return doctorRepository.findByDoctorEmail(email);
    }

    @Override
    public Page<Doctor> findByGender(Gender gender, Pageable pageable) {
        return doctorRepository.findByGender(gender, pageable);
    }

    @Override
    public Page<Doctor> findByDepartment(Department department, Pageable pageable) {
        return doctorRepository.findByDepartment(department, pageable);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

}
