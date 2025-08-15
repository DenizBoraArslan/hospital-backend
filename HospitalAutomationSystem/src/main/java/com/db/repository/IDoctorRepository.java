package com.db.repository;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findById(long doctorId);

    Page<Doctor> findByDoctorFirstName(String doctorFirstName, Pageable pageable);

    Page<Doctor> findByDoctorLastName(String doctorLastName, Pageable pageable);

    Optional<Doctor> findByDoctorEmail(String email);

    Page<Doctor> findByGender(Gender gender, Pageable pageable);

    Page<Doctor> findByDepartment(Department department, Pageable pageable);

    void delete(Doctor doctor);

    Page<Doctor> getAllDoctorsByDepartment(Department department, Pageable pageable);

    Page<Doctor> findAllDoctorsByGender(Gender gender, Pageable pageable);
}
