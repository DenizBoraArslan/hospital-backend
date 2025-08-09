package com.db.service.interfaces;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;


public interface IAppointmentService {

    Page<Appointment> findAppointmentByPatientId(Long patientId, Pageable pageable);

    Page<Appointment> findAppointmentByDoctorId(Long doctorId, Pageable pageable);

    Page<Appointment> findAppointmentByAppointmentDate(LocalDate appointmentDate, Pageable pageable);

    Page<Appointment> findAppointmentByStatus(AppointmentStatus status, Pageable pageable);

    Page<Appointment> findAllAppointments(Pageable pageable);

    Appointment saveAppointment(Appointment appointment);

    public void deleteAppointment(Long appointmentId);

    public Appointment updateAppointment(Appointment appointment);
}
