package com.db.service.interfaces;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {

    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
    List<Appointment> findByStatus(AppointmentStatus status);



}
