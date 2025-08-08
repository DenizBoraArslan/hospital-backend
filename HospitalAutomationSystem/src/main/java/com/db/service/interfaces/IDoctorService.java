package com.db.service.interfaces;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.models.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    Optional<Doctor> findById(long doctorId);
    List<Doctor> findByDoctorFirstName(String doctorFirstName);
    List<Doctor> findByDoctorLastName(String doctorLastName);
    Optional<Doctor> findByDoctorEmail(String email);
    List<Doctor> findByGender(Gender gender);
    List<Doctor> findByDepartment(Department department);



}
