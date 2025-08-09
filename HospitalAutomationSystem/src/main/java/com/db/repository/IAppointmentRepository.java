package com.db.repository;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {


    Page<Appointment> findAppointmentByPatientId(Long patientId, Pageable pageable);

    Page<Appointment> findAppointmentByDoctorId(Long doctorId, Pageable pageable);

    Page<Appointment> findAppointmentByAppointmentDate(LocalDate appointmentDate, Pageable pageable);

    Page<Appointment> findAppointmentByStatus(AppointmentStatus status, Pageable pageable);


}
