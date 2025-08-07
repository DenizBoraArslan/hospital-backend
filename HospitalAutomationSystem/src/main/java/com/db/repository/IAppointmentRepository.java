package com.db.repository;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import com.db.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
    List<Appointment> findByStatus(AppointmentStatus status);
    List<Appointment> findByDoctorIdAndAppointmentDate(long doctorId, LocalDate appointmentDate);
    List<Appointment> findByPatientIdAndStatus(long patientId, AppointmentStatus status);




}
