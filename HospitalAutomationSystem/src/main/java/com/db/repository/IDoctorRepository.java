package com.db.repository;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findById(long doctorId);
    List<Doctor> findByDoctorFirstName(String doctorFirstName);
    List<Doctor> findByDoctorLastName(String doctorLastName);
    Optional<Doctor> findByDoctorEmail(String email);
    List<Doctor> findByGender(Gender gender);
    List<Doctor> findByDepartment(Department department);

}
