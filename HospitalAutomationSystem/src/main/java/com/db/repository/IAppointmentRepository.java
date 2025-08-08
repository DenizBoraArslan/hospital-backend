package com.db.repository;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {


    List<Appointment> findAppointmentByPatientId(Long patientId);
    List<Appointment> findAppointmentByDoctorId(Long doctorId);
    List<Appointment> findAppointmentByAppointmentDate(LocalDate appointmentDate);
    List<Appointment> findAppointmentByStatus(AppointmentStatus status);



}
