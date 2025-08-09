package com.db.service;

import com.db.enums.AppointmentStatus;
import com.db.models.Appointment;
import com.db.repository.IAppointmentRepository;
import com.db.service.interfaces.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;


    @Override
    public Page<Appointment> findAppointmentByPatientId(Long patientId, Pageable pageable) {
        return appointmentRepository.findAppointmentByPatientId(patientId, pageable);
    }

    @Override
    public Page<Appointment> findAppointmentByDoctorId(Long doctorId, Pageable pageable) {
        return appointmentRepository.findAppointmentByDoctorId(doctorId, pageable);
    }

    @Override
    public Page<Appointment> findAppointmentByAppointmentDate(LocalDate appointmentDate, Pageable pageable) {
        return appointmentRepository.findAppointmentByAppointmentDate(appointmentDate, pageable);
    }

    @Override
    public Page<Appointment> findAppointmentByStatus(AppointmentStatus status, Pageable pageable) {
        return appointmentRepository.findAppointmentByStatus(status, pageable);
    }

    @Override
    public Page<Appointment> findAllAppointments(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {

        appointmentRepository.deleteById(appointmentId);

    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
