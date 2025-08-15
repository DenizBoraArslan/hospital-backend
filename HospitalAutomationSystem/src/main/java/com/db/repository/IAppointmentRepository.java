package com.db.repository;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {


    Optional<Appointment> findAppointmentByPatientId(Long patient_id);

    Page<Appointment> findAppointmentByDoctorId(Long doctor_id, Pageable pageable);

    Page<Appointment> findAppointmentByAppointmentDate(LocalDate appointmentDate, Pageable pageable);

    Page<Appointment> findAppointmentByStatus(AppointmentStatus status, Pageable pageable);


}
