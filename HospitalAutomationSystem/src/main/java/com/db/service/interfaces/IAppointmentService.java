package com.db.service.interfaces;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {

    List<Appointment> findAppointmentByPatientId(Long patientId);
    List<Appointment> findAppointmentByDoctorId(Long doctorId);
    List<Appointment> findAppointmentByAppointmentDate(LocalDate appointmentDate);
    List<Appointment> findAppointmentByStatus(AppointmentStatus status);
    List<Appointment> findAllAppointments();
    Appointment saveAppointment(Appointment appointment);
    public void deleteAppointment(Long appointmentId);
    public Appointment updateAppointment(Appointment appointment);
}
