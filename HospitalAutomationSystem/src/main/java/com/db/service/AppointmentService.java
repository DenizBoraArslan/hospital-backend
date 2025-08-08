package com.db.service;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import com.db.repository.IAppointmentRepository;
import com.db.service.interfaces.IAppointmentService;


import java.time.LocalDate;
import java.util.List;

public class AppointmentService implements IAppointmentService {


    private IAppointmentRepository AppointmentRepository;

    @Override
    public List<Appointment> findByPatientId(Long patientId) {
        return AppointmentRepository.findByPatientId(patientId) ;
    }

    @Override
    public List<Appointment> findByDoctorId(Long doctorId) {
        return AppointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> findByAppointmentDate(LocalDate appointmentDate) {
        return AppointmentRepository.findByAppointmentDate(appointmentDate);
    }

    @Override
    public List<Appointment> findByStatus(AppointmentStatus status) {
        return AppointmentRepository.findByStatus(status);
    }



}
