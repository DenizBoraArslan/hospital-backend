package com.db.service.interfaces;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IDoctorService {

    Optional<Doctor> findById(long doctorId);

    Page<Doctor> findByDoctorFirstName(String doctorFirstName, Pageable pageable);

    Page<Doctor> findByDoctorLastName(String doctorLastName, Pageable pageable);

    Optional<Doctor> findByDoctorEmail(String email);

    Page<Doctor> findByGender(Gender gender, Pageable pageable);

    Page<Doctor> findByDepartment(Department department, Pageable pageable);

    Doctor saveDoctor(Doctor doctor);

    void deleteDoctor(Doctor doctor);

    Doctor updateDoctor(Doctor doctor);

}
