package com.db.service.interfaces;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.print.Doc;
import java.util.Optional;

public interface IDoctorService {

    Page<Doctor> getAllDoctors(Pageable pageable);

    Page<Doctor> findAllDoctorsByGender(Gender gender, Pageable pageable);

    Page<Doctor> getAllDoctorsByDepartment(Department department, Pageable pageable);

    Optional<Doctor> findById(long doctorId);

    Page<Doctor> findByDoctorFirstName(String doctorFirstName, Pageable pageable);

    Page<Doctor> findByDoctorLastName(String doctorLastName, Pageable pageable);

    Optional<Doctor> findByDoctorEmail(String email);

    Page<Doctor> findByGender(Gender gender, Pageable pageable);

    Page<Doctor> findByDepartment(Department department, Pageable pageable);

    Doctor saveDoctor(Doctor doctor);

    public void deleteDoctor(Doctor doctor);

    public Doctor updateDoctor(Doctor doctor);


}
